package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;

public class HungerGamePersistence extends AbstractConfPersistence<HungerGameConfiguration> {
	private static final String HUNGER_GAME = GAME + "HungerGame/";

	public HungerGamePersistence() {
		super(HungerGameConfiguration.DEFAULT);
		checkAndWriteDefault(HUNGER_GAME, get());
	}

	@Override
	public boolean exist(String name) {
		return super.exist(HUNGER_GAME + name + ".xml");
	}

	@Override
	public void load(String name) throws FileNotFoundException {

	}

	@Override
	public void save() {
		StringBuilder builder = new StringBuilder();
		builder.append(openingTag("configuration")).append(attribut(1, "name", configuration.getName()))
				.append(openingTabTag(1, "border")).append(openingTabTag(2, "center"))
				.append(attribut(3, "x", configuration.getBorderCenter().getX()))
				.append(attribut(3, "y", configuration.getBorderCenter().getY()))
				.append(attribut(3, "z", configuration.getBorderCenter().getZ())).append(closingTabTag(2, "center"))
				.append(openingTabTag(2, "size")).append(attribut(3, "initial", configuration.getInitialBorderSize()))
				.append(attribut(3, "final", configuration.getFinalBorderSize())).append(closingTabTag(2, "size"))
				.append(closingTabTag(1, "border")).append(openingTabTag(1, "time"))
				.append(attribut(2, "total", configuration.getGameTime()))
				.append(attribut(2, "fraction", configuration.getFractionTime()))
				.append(attribut(2, "scoreboardrefresh", configuration.getScoreboardRefresh()))
				.append(closingTabTag(1, "time")).append(closingTag("configuration"));
		write(HUNGER_GAME + configuration.getName() + ".xml", builder.toString());
	}

	@Override
	public HungerGameConfiguration get() {
		return configuration;
	}

	@Override
	public void set(HungerGameConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public List<String> list() {
		return getList(HUNGER_GAME);
	}
}
