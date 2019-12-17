package fr.pederobien.uhc.persistence.loaders.configurations.blockedexgame;

import fr.pederobien.uhc.configurations.BlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.persistence.loaders.configurations.AbstractConfigurationLoader;

public abstract class AbstractBlockedexgameLoader extends AbstractConfigurationLoader<IBlockedexConfiguration> {

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
		System.out.println("\tNorth base : " + get().getNorthBase());
		System.out.println("\tSouth base : " + get().getSouthBase());
		System.out.println("\tWest base : " + get().getWestBase());
		System.out.println("\tEast base : " + get().getEastBase());
		System.out.println("\tDistance from spawn : " + get().getBaseFromSpawnDistance());
		System.out.println("Team");
		for (ITeam team : get().getTeams())
			System.out.println("\tName : " + team.getName() + ", color : " + team.getColor().getColorName());
	}
}
