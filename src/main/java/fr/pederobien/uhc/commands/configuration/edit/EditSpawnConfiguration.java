package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn.SpawnEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.ISpawn;

public class EditSpawnConfiguration extends AbstractEditConfiguration<ISpawn> {
	private SpawnEditionsFactory factory = SpawnEditionsFactory.getInstance();

	public EditSpawnConfiguration(IConfigurationContext context) {
		super(context, "spawn", "to configure a spawn");

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
