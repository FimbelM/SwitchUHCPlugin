package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.AsCurrent;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.BorderCenterEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Current;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.FinalBorderDiameter;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.FractionTime;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.GameTime;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Help;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.InitialBorderDiameter;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.ListConf;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Load;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.NewConf;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Rename;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.Save;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.ScoreboardRefresh;
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class EditHungerGameConfiguration extends AbstractEditConfiguration<IHungerGameConfiguration> {
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
	private IEdition help;

	public EditHungerGameConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected IPersistence<IHungerGameConfiguration> getPersistenceImpl() {
		return ConfigurationsFactory.getInstance().getHungerGamePersistence();
	}

	@Override
	protected void setEditions() {
		borderCenter = new BorderCenterEdition(getPersistence());
		initialBorderDiameter = new InitialBorderDiameter(getPersistence());
		finalBorderDiameter = new FinalBorderDiameter(getPersistence());
		gameTime = new GameTime(getPersistence());
		fractionTime = new FractionTime(getPersistence());
		scoreboardRefresh = new ScoreboardRefresh(getPersistence());
		rename = new Rename(getPersistence());
		load = new Load(getPersistence());
		newConf = new NewConf(getPersistence());
		current = new Current(getPersistence());
		asCurrent = new AsCurrent(getPersistence(), context);
		save = new Save(getPersistence());
		list = new ListConf(getPersistence());
		help = new Help(getPersistence());

		addToMap(borderCenter, initialBorderDiameter, finalBorderDiameter, gameTime, fractionTime, scoreboardRefresh,
				rename, load, newConf, current, asCurrent, save, list, help);
	}
}
