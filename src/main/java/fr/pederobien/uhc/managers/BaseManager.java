package fr.pederobien.uhc.managers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class BaseManager {
	private static List<IUnmodifiableBase> allBases;
	private static List<IUnmodifiableBase> gameBases;

	static {
		allBases = new ArrayList<IUnmodifiableBase>();
		gameBases = new ArrayList<IUnmodifiableBase>();

		PersistenceFactory factory = PersistenceFactory.getInstance();
		try {
			for (String name : factory.getBasePersistence().list())
				allBases.add((IUnmodifiableBase) factory.getBasePersistence().load(name).get());
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
}
