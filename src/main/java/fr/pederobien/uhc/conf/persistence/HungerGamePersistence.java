package fr.pederobien.uhc.conf.persistence;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;

public class HungerGamePersistence extends AbstractConfPersistence<HungerGameConfiguration> {
	private static final String HUNGER_GAME = GAME + "Hunger game";
	
	public HungerGamePersistence(HungerGameConfiguration configuration) {
		super(configuration);
		checkAndWriteDefault(HUNGER_GAME, HungerGameConfiguration.DEFAULT);
	}

	@Override
	public HungerGameConfiguration load(String name) {
		return null;
	}

	@Override
	public void save(HungerGameConfiguration configuration) {
		StringBuilder builder = new StringBuilder();
		builder.append(openingTag("configuration"))
		.append(tabAttribut(1, "name", configuration.getName()))
		.append(tabAttribut(1, "spawn", configuration.getSpawn().getName()))
		.append(openingTabTag(2, "border"))
		.append(openingTabTag(1, "border"))
		.append(openingTabTag(2, "center"))
		.append(tabAttribut(3, "x", configuration.getBorderCenter().getX()))
		.append(tabAttribut(3, "y", configuration.getBorderCenter().getY()))
		.append(tabAttribut(3, "z", configuration.getBorderCenter().getZ()))
		.append(closingTabTag(2, "center"))
		.append(openingTabTag(2, "size"))
		.append(tabAttribut(3, "initial", configuration.getInitialBorderSize()))
		.append(tabAttribut(3, "final", configuration.getFinalBorderSize()))
		.append(closingTabTag(2, "size"))
		.append(closingTabTag(1, "border"))
		.append(openingTabTag(1, "time"))
		.append(tabAttribut(3, "total", configuration.getGameTime()))
		.append(tabAttribut(3, "fraction", configuration.getFractionTime()))
		.append(tabAttribut(3, "scoreboardrefresh", configuration.getScoreboardRefresh()))
		.append(closingTabTag(1, "time"))
		.append(closingTag("configuration"));
		
		write(HUNGER_GAME, builder.toString());
	}
}
