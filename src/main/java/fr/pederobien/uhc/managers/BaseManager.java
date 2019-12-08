package fr.pederobien.uhc.managers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.Material;
import org.bukkit.block.Block;

import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.event.PlayerInteractEventResponse;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.pederobien.uhc.persistence.PersistenceFactory;

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
		try {
			if (checkBaseAvailable(configuration.getNorthBase(), configuration.getTeams())) {
				IBase north = (IBase) allBases.get(configuration.getNorthBase()).clone();
				north.setCenter(WorldManager.getHighestBlockFromSpawn(0, 0, configuration.getBaseFromSpawnDistance()));
				gameBases.put(Orientation.NORTH, north);
			}
			if (checkBaseAvailable(configuration.getSouthBase(), configuration.getTeams())) {
				IBase south = (IBase) (IBase) allBases.get(configuration.getSouthBase()).clone();
				south.setCenter(WorldManager.getHighestBlockFromSpawn(0, 0, -configuration.getBaseFromSpawnDistance()));
				gameBases.put(Orientation.SOUTH, south);
			}
			if (checkBaseAvailable(configuration.getWestBase(), configuration.getTeams())) {
				IBase west = (IBase) allBases.get(configuration.getWestBase()).clone();
				west.setCenter(WorldManager.getHighestBlockFromSpawn(-configuration.getBaseFromSpawnDistance(), 0, 0));
				gameBases.put(Orientation.WEST, west);
			}
			if (checkBaseAvailable(configuration.getEastBase(), configuration.getTeams())) {
				IBase east = (IBase) allBases.get(configuration.getEastBase()).clone();
				east.setCenter(WorldManager.getHighestBlockFromSpawn(configuration.getBaseFromSpawnDistance(), 0, 0));
				gameBases.put(Orientation.EAST, east);
			}

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return gameBases.size() == 4;
	}

	public static void launchBlockedexBases() {
		gameBases.values().forEach(b -> b.launch());
	}

	public static void removeBlockedexBases() {
		gameBases.values().forEach(b -> b.remove());
	}

	public static PlayerInteractEventResponse isRestricted(ETeam color, Block block) {
		if (!block.getType().equals(Material.CHEST))
			return EventFactory.createPlayerInteractEventResponse(false, null);

		for (IBase base : gameBases.values()) {
			PlayerInteractEventResponse response = base.isChestRestricted(block, color);
			if (response.isRestricted())
				return response;
		}
		return new PlayerInteractEventResponse(false, null);
	}

	public static Stream<String> availableBasesAccordingTeam(List<ETeam> teams) {
		return allBases.values().stream().filter(b -> checkBaseAvailable(b, teams)).map(b -> b.getName());
	}

	public static boolean checkBaseAvailable(String baseName, List<ETeam> teams) {
		return checkBaseAvailable(allBases.get(baseName), teams);
	}

	public static IUnmodifiableBase getBaseByName(String name) {
		return allBases.get(name);
	}

	public static boolean checkBaseAvailable(IBase base, List<ETeam> teams) {
		if (base == null)
			return false;
		if (teams.size() <= base.getChestsNumber()) {
			boolean supportTeam = true;
			for (ETeam team : teams) {
				supportTeam &= base.getChests().containsValue(team);
				if (!supportTeam)
					return false;
			}
			return true;
		}
		return false;
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
