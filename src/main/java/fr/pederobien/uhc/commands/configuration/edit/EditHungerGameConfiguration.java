package fr.pederobien.uhc.commands.configuration.edit;

import java.util.HashMap;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.AsCurrent;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.BorderCenterEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.FinalBorderDiameter;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.FractionTime;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.GameTime;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.InitialBorderDiameter;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.ListConf;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Load;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.NewConf;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Rename;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Save;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.ScoreboardRefresh;
import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class EditHungerGameConfiguration extends AbstractEditConfiguration implements IEditConfig {
	private HungerGamePersistence persistence;
	private final IEdition borderCenter;
	private final IEdition initialBorderDiameter;
	private final IEdition finalBorderDiameter;
	private final IEdition gameTime;
	private final IEdition fractionTime;
	private final IEdition scoreboardRefresh;
	private final IEdition rename;
	private final IEdition load;
	private final IEdition newConf;
	private final IEdition asCurrent;
	private final IEdition save;
	private final IEdition list;
	private HashMap<String, IEdition> map;

	public EditHungerGameConfiguration(ConfigurationContext context) {
		super(context);
		
		persistence = new HungerGamePersistence();
		map = new HashMap<String, IEdition>();

		borderCenter = new BorderCenterEdition(persistence);
		initialBorderDiameter = new InitialBorderDiameter(persistence);
		finalBorderDiameter = new FinalBorderDiameter(persistence);
		gameTime = new GameTime(persistence);
		fractionTime = new FractionTime(persistence);
		scoreboardRefresh = new ScoreboardRefresh(persistence);
		rename = new Rename(persistence);
		load = new Load(persistence);
		newConf = new NewConf(persistence);
		asCurrent = new AsCurrent(persistence, context);
		save = new Save(persistence);
		list = new ListConf(persistence);

		addToMap(borderCenter, initialBorderDiameter, finalBorderDiameter, gameTime, fractionTime, scoreboardRefresh,
				rename, load, newConf, asCurrent, save, list);
	}

	@Override
	protected void setEditions() {

	}

	@Override
	public boolean edit(String[] args) {
		try {
			setMessage(map.get(args[0]).edit(args));
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			return false;
		}
		return true;
	}

	@Override
	public String getEditCommands() {
		return new StringBuilder("Unknown command\r\n").append(getEditionsHelp()).toString();
	}

	private void addToMap(IEdition... editions) {
		for (IEdition edition : editions)
			map.put(edition.getLabel(), edition);
	}

	@Override
	protected String getEditionsHelp() {
		String help = "List of existing commands\r\n";
		for (String label : map.keySet()) {
			help += map.get(label).help();
			help += "\r\n";
		}
		return help;
	}
}
