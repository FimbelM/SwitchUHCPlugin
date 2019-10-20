package fr.pederobien.uhc.persistence.loader.hungergame;

import fr.pederobien.uhc.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.persistence.loader.AbstractPersistenceLoader;

public abstract class AbstractHungerGameLoader extends AbstractPersistenceLoader<IHungerGameConfiguration> {

	public AbstractHungerGameLoader(String version) {
		super(version, new HungerGameConfiguration("DefaultConfiguration"));
	}

	protected void show() {
		System.out.println("Name : " + get().getName());
		System.out.println("Border");
		System.out.println("\tCenter : " + get().getBorderCenter().getX() + " " + get().getBorderCenter().getZ());
		System.out.println("\tDiameter");
		System.out.println("\t\tInitial : " + get().getInitialBorderDiameter());
		System.out.println("\t\tFinal : " + get().getFinalBorderDiameter());
		System.out.println("Time");
		System.out.println("\tGame : " + get().getGameTime());
		System.out.println("\tFraction : " + get().getFractionTime());
		System.out.println("\tScoreboard refresh : " + get().getScoreboardRefresh());
	}
}
