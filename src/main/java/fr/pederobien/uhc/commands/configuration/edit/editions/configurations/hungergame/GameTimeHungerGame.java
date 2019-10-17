package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public class GameTimeHungerGame extends CommonGameTime<IHungerGameConfiguration> {

	public GameTimeHungerGame(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "to set the time after which the world border move from its initial to final diameter");
	}
}
