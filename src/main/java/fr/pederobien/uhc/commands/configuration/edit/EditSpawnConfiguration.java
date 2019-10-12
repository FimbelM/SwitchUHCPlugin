package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.SpawnEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class EditSpawnConfiguration extends AbstractEditConfiguration<ISpawn> {
	private SpawnEditionsFactory factory;

	public EditSpawnConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected void setEditions() {
		factory = SpawnEditionsFactory.getInstance();

		addToMap(factory.createCenterEdition(),
				factory.createDimensionsEdition(),
				factory.createRenameEdition(),
				factory.createCurrentEdition(),
				factory.createNewSpawnEdition(),
				factory.createLaunchEdition(),
				factory.createSaveEdition(),
				factory.createRemoveEdition(),
				factory.createExtractEdition(),
				factory.createListEdition(),
				factory.createHelpEdition());
	}
}
