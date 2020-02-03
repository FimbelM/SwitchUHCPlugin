package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn.SpawnEditionsFactory;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class EditSpawnConfiguration extends AbstractEditConfiguration<ISpawn> {
	private static final SpawnEditionsFactory factory = SpawnEditionsFactory.getInstance();

	public EditSpawnConfiguration() {
		super(factory.getPersistence(), "spawn", MessageCode.SPAWN_EDITION_CONFIGURATION_EXPLANATION);

		addEdition(factory.createCenterEdition()).addEdition(factory.createCurrentEdition()).addEdition(factory.createDeleteEdition().setModifiable(false))
				.addEdition(factory.createDimensionsEdition()).addEdition(factory.createExtractEdition()).addEdition(factory.createLaunchEdition().setModifiable(false))
				.addEdition(factory.createListEdition().setModifiable(false)).addEdition(factory.createNewEdition().setModifiable(false))
				.addEdition(factory.createPlayerSpawnEdition()).addEdition(factory.createRandomEdition().setModifiable(false)).addEdition(factory.createRemoveEdition())
				.addEdition(factory.createRenameEdition()).addEdition(factory.createResetEdition()).addEdition(factory.createSaveEdition());
	}
}
