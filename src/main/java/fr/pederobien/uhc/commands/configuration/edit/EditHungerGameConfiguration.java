package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.AsCurrent;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.BorderCenterEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Current;
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

	private IEdition borderCenter;
	private IEdition initialBorderDiameter;
	private IEdition finalBorderDiameter;
	private IEdition gameTime;
	private IEdition fractionTime;
	private IEdition scoreboardRefresh;
	private IEdition rename;
	private IEdition load;
	private IEdition newConf;
	private IEdition current;
	private IEdition asCurrent;
	private IEdition save;
	private IEdition list;

	public EditHungerGameConfiguration(ConfigurationContext context) {
		super(context);

		persistence = new HungerGamePersistence();

		borderCenter = new BorderCenterEdition(persistence);
		initialBorderDiameter = new InitialBorderDiameter(persistence);
		finalBorderDiameter = new FinalBorderDiameter(persistence);
		gameTime = new GameTime(persistence);
		fractionTime = new FractionTime(persistence);
		scoreboardRefresh = new ScoreboardRefresh(persistence);
		rename = new Rename(persistence);
		load = new Load(persistence);
		newConf = new NewConf(persistence);
		current = new Current(persistence);
		asCurrent = new AsCurrent(persistence, context);
		save = new Save(persistence);
		list = new ListConf(persistence);
	}

	@Override
	protected void setEditions() {
		addToMap(borderCenter, initialBorderDiameter, finalBorderDiameter, gameTime, fractionTime, scoreboardRefresh,
				rename, load, newConf, current, asCurrent, save, list);
	}
}
