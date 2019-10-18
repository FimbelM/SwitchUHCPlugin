package fr.pederobien.uhc.managers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class BaseManager {
	private static List<IBase> allBases;
	private static List<IBase> gameBases;

	static {
		allBases = new ArrayList<IBase>();
		gameBases = new ArrayList<IBase>();

		IPersistence<IBase> persistence = PersistenceFactory.getInstance().getBasePersistence();
		try {
			for (String name : persistence.list())
				allBases.add(persistence.load(name).get());
		} catch (FileNotFoundException e) {
		}
	}

	public static boolean isChestAccessible(Player player, Block block) {
		if (!block.getType().equals(Material.CHEST))
			return true;

		boolean accessible = true;
		for (IUnmodifiableBase base : gameBases)
			accessible &= !base.isChestRestricted(block, player);
		return accessible;
	}

	public static List<String> availableBasesAccordingTeam() {
		List<String> availableBases = new ArrayList<String>();
		List<Team> teams = TeamsManager.getTeams();
		
		for (IUnmodifiableBase base : allBases)
			if (checkBaseAvailable(base, teams))
				availableBases.add(base.getName());
		return availableBases;
	}

	public static boolean checkBaseAvailable(IUnmodifiableBase base, List<Team> teams) {
		if (teams.size() <= base.getChestsNumber()) {
			boolean supportTeam = true;
			for (Team team : teams) {
				supportTeam &= base.getChests().containsValue(team.getColor());
				if (!supportTeam)
					return false;
			}
			return true;
		}
		return false;
	}
	
	public static boolean checkBaseAvailable(String baseName) {
		for (IBase base : allBases)
			if (base.getName().equals(baseName))
				return checkBaseAvailable(base, TeamsManager.getTeams());
		return false;
	}
	
	public static IUnmodifiableBase getBaseByName(String name) {
		for (IBase base : allBases)
			if (base.getName().equals(name))
				return base;
		return null;
	}
}
