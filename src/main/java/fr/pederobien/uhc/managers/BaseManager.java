package fr.pederobien.uhc.managers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.event.PlayerInteractEventResponse;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.pederobien.uhc.persistence.PersistenceFactory;
import fr.pederobien.uhc.world.blocks.Base;
import fr.pederobien.uhc.world.blocks.Dimension;

public class BaseManager {
	private static HashMap<String, IBase> allBases = new HashMap<String, IBase>();
	private static HashMap<Orientation, IBase> gameBases = new HashMap<Orientation, IBase>();
	private static boolean loaded = false;

	public static void loadBases() {
		if (loaded)
			return;
		IPersistence<IBase> persistence = PersistenceFactory.getInstance().getBasePersistence();
		try {
			for (String name : persistence.list())
				allBases.put(name, persistence.load(name).get());
		} catch (FileNotFoundException e) {
		}
		loaded = true;
	}

	public static boolean setBlockedexGameCurrentConfiguration(IUnmodifiableBlockedexConfiguration configuration) {
		if (checkBaseAvailable(configuration.getNorthBase(), configuration.getTeams())) {
			IBase north = copy(allBases.get(configuration.getNorthBase()));
			north.setCenter(WorldManager.getHighestBlockFromSpawn(0, 0, configuration.getBaseFromSpawnDistance()));
			gameBases.put(Orientation.NORTH, north);
		}
		if (checkBaseAvailable(configuration.getSouthBase(), configuration.getTeams())) {
			IBase south = copy(allBases.get(configuration.getSouthBase()));
			south.setCenter(WorldManager.getHighestBlockFromSpawn(0, 0, -configuration.getBaseFromSpawnDistance()));
			gameBases.put(Orientation.SOUTH, south);
		}
		if (checkBaseAvailable(configuration.getWestBase(), configuration.getTeams())) {
			IBase west = copy(allBases.get(configuration.getWestBase()));
			west.setCenter(WorldManager.getHighestBlockFromSpawn(-configuration.getBaseFromSpawnDistance(), 0, 0));
			gameBases.put(Orientation.WEST, west);
		}
		if (checkBaseAvailable(configuration.getEastBase(), configuration.getTeams())) {
			IBase east = copy(allBases.get(configuration.getEastBase()));
			east.setCenter(WorldManager.getHighestBlockFromSpawn(configuration.getBaseFromSpawnDistance(), 0, 0));
			gameBases.put(Orientation.EAST, east);
		}
		return gameBases.size() == 4;
	}

	public static void launchBlockedexBases() {
		gameBases.values().forEach(b -> b.launch());
	}

	public static void removeBlockedexBases() {
		gameBases.values().forEach(b -> b.remove());
	}

	public static PlayerInteractEventResponse isRestricted(PlayerInteractEvent event) {
		if (!event.getClickedBlock().getType().equals(Material.CHEST))
			return EventFactory.createPlayerInteractEventResponse(event, false, null);

		for (IBase base : gameBases.values()) {
			PlayerInteractEventResponse response = base.isChestRestricted(event);
			if (response.isRestricted())
				return response;
		}
		return EventFactory.createPlayerInteractEventResponse(event, false, null);
	}

	public static Stream<String> availableBasesAccordingTeam(List<ITeam> teams) {
		return allBases.values().stream().filter(b -> checkBaseAvailable(b, teams)).map(b -> b.getName());
	}

	public static boolean checkBaseAvailable(String baseName, List<ITeam> teams) {
		return checkBaseAvailable(allBases.get(baseName), teams);
	}

	public static IUnmodifiableBase getBaseByName(String name) {
		return allBases.get(name);
	}

	public static boolean checkBaseAvailable(IBase base, List<ITeam> teams) {
		if (base == null)
			return false;
		if (teams.size() <= base.getChestsNumber()) {
			boolean supportTeam = true;
			for (ITeam team : teams) {
				supportTeam &= base.getChests().containsValue(team.getColor());
				if (!supportTeam)
					return false;
			}
			return true;
		}
		return false;
	}

	public static IBase copy(IBase origin) {
		IBase copy = new Base(origin.getName());
		copy.setBlocks(origin.getBlocks());
		copy.setCenter(origin.getCenter());
		copy.setChests(origin.getChests());
		copy.setDimension(new Dimension(origin.getWidth(), origin.getHeight(), origin.getDepth()));
		return copy;
	}

	public static Block getNorthBaseCenter() {
		return getCenter(Orientation.NORTH);
	}

	public static Block getSouthBaseCenter() {
		return getCenter(Orientation.SOUTH);
	}

	public static Block getWestBaseCenter() {
		return getCenter(Orientation.WEST);
	}

	public static Block getEastBaseCenter() {
		return getCenter(Orientation.EAST);
	}

	private static Block getCenter(Orientation orientation) {
		return gameBases.get(orientation).getCenter();
	}

	private enum Orientation {
		NORTH, SOUTH, WEST, EAST;
	}
}
