package fr.pederobien.uhc.conf.persistence;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;

public class HungerGamePersistence extends AbstractConfPersistence<HungerGameConfiguration> {
	private static final String HUNGER_GAME = GAME + "Hunger game";
	
	public HungerGamePersistence(HungerGameConfiguration game) {
		super(game);
		checkAndWriteDefaultConf(HUNGER_GAME, HungerGameConfiguration.DEFAULT);
	}

	@Override
	public HungerGameConfiguration load(String name) {
		return null;
	}

	@Override
	public void save(HungerGameConfiguration configuration) {
		
	}
}
