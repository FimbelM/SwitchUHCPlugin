package fr.martinfimbel.switchuhc.persistence.loaders.configurations.hungergame;

import fr.martinfimbel.switchuhc.configurations.HungerGameConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;
import fr.martinfimbel.switchuhc.persistence.loaders.configurations.AbstractConfigurationLoader;

public abstract class AbstractHungerGameLoader extends AbstractConfigurationLoader<IHungerGameConfiguration> {

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
