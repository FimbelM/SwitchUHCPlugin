package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn.SpawnEditionsFactory;
import fr.pederobien.uhc.interfaces.ISpawn;

public class EditSpawnConfiguration extends AbstractEditConfiguration<ISpawn> {
	private static final SpawnEditionsFactory factory = SpawnEditionsFactory.getInstance();

	public EditSpawnConfiguration() {
		super(factory.getPersistence(), "spawn", "to configure a spawn");
				
		addEdition(factory.createCenterEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createDimensionsEdition())
		.addEdition(factory.createExtractEdition())
		.addEdition(factory.createHelpEdition(this).setUnmodifiable(true))
		.addEdition(factory.createLaunchEdition().setUnmodifiable(true))
		.addEdition(factory.createListEdition())
		.addEdition(factory.createNewEdition().setUnmodifiable(true))
		.addEdition(factory.createRemoveEdition())
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition());
	}
}
