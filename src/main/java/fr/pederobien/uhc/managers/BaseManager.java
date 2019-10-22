package fr.pederobien.uhc.managers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class BaseManager {
	private static HashMap<String, IBase> allBases = new HashMap<String, IBase>();
	private static HashMap<String, IBase> gameBases = new HashMap<String, IBase>();
	private static boolean loaded = false;
	
	public static void loadPersistences() {
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

	public static boolean isChestAccessible(Player player, Block block) {
		if (!block.getType().equals(Material.CHEST))
			return true;

		boolean accessible = true;
		for (IUnmodifiableBase base : gameBases.values())
			accessible &= !base.isChestRestricted(block, player);
		return accessible;
	}

	public static List<String> availableBasesAccordingTeam(List<ETeam> teams) {
		List<String> availableBases = new ArrayList<String>();

		for (IBase base : allBases.values())
			if (checkBaseAvailable(base, teams))
				availableBases.add(base.getName());
		return availableBases;
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
}
