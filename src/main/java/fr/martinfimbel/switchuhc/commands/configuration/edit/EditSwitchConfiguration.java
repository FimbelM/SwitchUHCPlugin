package fr.martinfimbel.switchuhc.commands.configuration.edit;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching.SwitchGameEditionsFactory;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class EditSwitchConfiguration extends AbstractEditConfiguration<ISwitchGameConfiguration> {
	private static final SwitchGameEditionsFactory factory = SwitchGameEditionsFactory.getInstance();

	public EditSwitchConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "sw", MessageCode.SWITCH_GAME_EDITION_CONFIGURATION_EXPLANATION);

		addEdition(factory.createAsCurrentEdition(context)).addEdition(factory.createBorderCenterEdition())
				.addEdition(factory.createCurrentEdition())
				.addEdition(factory.createDeleteEdition().setModifiable(false))
				.addEdition(factory.createFinalBorderDiameterEdition()).addEdition(factory.createFractionTimeEdition())
				.addEdition(factory.createGameTimeEdition()).addEdition(factory.createInitialBorderDiameterEdition())
				.addEdition(factory.createListEdition().setModifiable(false))
				.addEdition(factory.createLoadEdition().setModifiable(false))
				.addEdition(factory.createNewEdition().setModifiable(false)).addEdition(factory.createPvpTimeEdition())
				.addEdition(factory.createRenameEdition()).addEdition(factory.createResetEdition())
				.addEdition(factory.createSaveEdition()).addEdition(factory.createScoreboardRefreshEdition())
				.addEdition(factory.createSpeedBorderEdition()).addEdition(factory.createTeamEdition())
				.addEdition(factory.createWarningTimeEdition()).addEdition(factory.createStartSwitchTimeEdition())
				.addEdition(factory.createSwitchTimeEdititon())
				.addEdition(factory.createNumberOfPlayerSwitchableEdition())
				.addEdition(factory.createSwitchAfterBorderMovesEdition()).addEdition(factory.createOnePlayerSwitchEdition());
	}
}
