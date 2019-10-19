package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn.SpawnEditionsFactory;

public class EditSpawnConfiguration extends AbstractMapEdition {
	private SpawnEditionsFactory factory = SpawnEditionsFactory.getInstance();

	public EditSpawnConfiguration() {
		super("spawn", "to configure a spawn");

		addEditions(factory.createCenterEdition(),
				factory.createDimensionsEdition(),
				factory.createRenameEdition(),
				factory.createCurrentEdition(),
				factory.createNewEdition(),
				factory.createLaunchEdition(),
				factory.createSaveEdition(),
				factory.createRemoveEdition(),
				factory.createExtractEdition(),
				factory.createListEdition(),
				factory.createHelpEdition(this));
	}
}
