package fr.pederobien.uhc.managers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class BaseManager {
	private static HashMap<String, IBase> allBases = new HashMap<String, IBase>();
	private static HashMap<Orientation, IBase> gameBases = new HashMap<Orientation, IBase>();
	private static IUnmodifiableBlockedexConfiguration configuration;
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
		BaseManager.configuration = configuration;
		if (checkBaseAvailable(configuration.getEastBase(), configuration.getTeams()))
			gameBases.put(Orientation.EAST, allBases.get(configuration.getEastBase()));
		if (checkBaseAvailable(configuration.getNorthBase(), configuration.getTeams()))
			gameBases.put(Orientation.NORTH, allBases.get(configuration.getNorthBase()));
		if (checkBaseAvailable(configuration.getSouthBase(), configuration.getTeams()))
			gameBases.put(Orientation.SOUTH, allBases.get(configuration.getSouthBase()));
		if (checkBaseAvailable(configuration.getWestBase(), configuration.getTeams()))
			gameBases.put(Orientation.WEST, allBases.get(configuration.getWestBase()));
		return gameBases.size() == 4;
	}
	
	public static void launchBlockedexBases() {
		gameBases.get(Orientation.NORTH).setCenter(WorldManager.getSpawnOnJoin().getBlock().getRelative(0, 0, configuration.getBaseFromSpawnDistance()));
		gameBases.get(Orientation.SOUTH).setCenter(WorldManager.getSpawnOnJoin().getBlock().getRelative(0, 0, -configuration.getBaseFromSpawnDistance()));
		gameBases.get(Orientation.WEST).setCenter(WorldManager.getSpawnOnJoin().getBlock().getRelative(-configuration.getBaseFromSpawnDistance(), 0, 0));
		gameBases.get(Orientation.EAST).setCenter(WorldManager.getSpawnOnJoin().getBlock().getRelative(configuration.getBaseFromSpawnDistance(), 0, 0));
		
		gameBases.values().forEach(b -> b.launch());
	}
	
	public static void removeBlockedexBases() {
		gameBases.values().forEach(b -> b.remove());
	}

	public static boolean isChestAccessible(Player player, Block block) {
		if (!block.getType().equals(Material.CHEST))
			return true;

		boolean accessible = true;
		for (IBase base : gameBases.values())
			accessible &= !base.isChestRestricted(block, player);
		return accessible;
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
	
	private enum Orientation {
		NORTH, SOUTH, WEST, EAST;
	}
}
