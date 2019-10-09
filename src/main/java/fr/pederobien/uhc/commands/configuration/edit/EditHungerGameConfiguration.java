package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.HungerGameEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;

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

	private HungerGameEditionsFactory factory;

	public EditHungerGameConfiguration(IConfigurationContext context) {
		super(context);
		factory = HungerGameEditionsFactory.getInstance();
	}

	@Override
	protected void setEditions() {
		borderCenter = factory.createBorderCenterEdition();
		initialBorderDiameter = factory.createInitialBorderDiameterEdition();
		finalBorderDiameter = factory.createFinalBorderDiameterEdition();
		gameTime = factory.createGameTimeEdition();
		fractionTime = factory.createFractionTimeEdition();
		scoreboardRefresh = factory.createScoreboardRefreshEdition();
		rename = factory.createRenameEdition();
		load = factory.createLoadEdition();
		newConf = factory.createNewConfEdition();
		current = factory.createCurrentEdition();
		asCurrent = factory.createAsCurrentEdition(context);
		save = factory.createSaveEdition();
		list = factory.createListEdition();
		help = factory.createHelpEdition();

		addToMap(borderCenter, initialBorderDiameter, finalBorderDiameter, gameTime, fractionTime, scoreboardRefresh,
				rename, load, newConf, current, asCurrent, save, list, help);
	}
}
