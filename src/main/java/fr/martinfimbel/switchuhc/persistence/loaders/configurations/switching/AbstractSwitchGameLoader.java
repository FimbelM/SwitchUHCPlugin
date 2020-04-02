package fr.martinfimbel.switchuhc.persistence.loaders.configurations.switching;

import fr.martinfimbel.switchuhc.configurations.SwitchConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;
import fr.martinfimbel.switchuhc.persistence.loaders.configurations.AbstractConfigurationLoader;

public abstract class AbstractSwitchGameLoader extends AbstractConfigurationLoader<ISwitchGameConfiguration>{

		public AbstractSwitchGameLoader(String version) {
			super(version, new SwitchConfiguration("DefaultConfiguration"));
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
			System.out.println("Startswitch : " + get().getStartSwitchTime());
			System.out.println("Switchtime : " + get().getPeriodSwitchTime());
			System.out.println("\tScoreboard refresh : " + get().getScoreboardRefresh());
			System.out.println("\tNumber of switched person : " + get().getNumberOfPlayerSwitchable());
			System.out.println("\tSwitch after border moves : " + get().getSwitchAfterBorderMoves());
		}
}
