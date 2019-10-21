package fr.pederobien.uhc.persistence.loaders.configurations.blockedexgame;

import fr.pederobien.uhc.configurations.BlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.persistence.loaders.AbstractPersistenceLoader;

public abstract class AbstractBlockedexgameLoader extends AbstractPersistenceLoader<IBlockedexConfiguration> {

	public AbstractBlockedexgameLoader(String version) {
		super(version, new BlockedexConfiguration("DefaultConfiguration"));
	}
	
	protected void show() {
		System.out.println("Name : " + get().getName());
		System.out.println("Area on player die : " + get().getRadiusAreaOnPlayerDie());
		System.out.println("Area on player kill : " + get().getRadiusAreaOnPlayerKill());
		System.out.println("Step on max health : " + get().getStepOnMaxHealth());
		System.out.println("Diameter on player kill : " + get().getDiameterAreaOnPlayerRespawn());
		System.out.println("Bases");
		System.out.println("\tNorth base : " + get().getNorthBase().getName());
		System.out.println("\tSouth base : " + get().getSouthBase().getName());
		System.out.println("\tWest base : " + get().getWestBase().getName());
		System.out.println("\tEast base : " + get().getEastBase().getName());
		System.out.println("\tDistance from spawn : " + get().getBaseFromSpawnDistance());
		System.out.println("Team");
		for (ETeam team : get().getTeams())
			System.out.println("\tName : " + team.getNameWithoutColor() + ", color : " + team.getColor());
	}
}
