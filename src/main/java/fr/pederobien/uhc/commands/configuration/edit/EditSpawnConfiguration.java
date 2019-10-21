package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn.SpawnEditionsFactory;
import fr.pederobien.uhc.interfaces.ISpawn;

public class EditSpawnConfiguration extends AbstractEditConfiguration<ISpawn> {
	private static final SpawnEditionsFactory factory = SpawnEditionsFactory.getInstance();

	public EditSpawnConfiguration() {
		super(factory.getPersistence(), "spawn", "to configure a spawn");
		
		IMapEdition launch = factory.createLaunchEdition();
		IMapEdition newSpawn = factory.createNewEdition();

		addEditions(factory.createCenterEdition(),
				factory.createDimensionsEdition(),
				factory.createRenameEdition(),
				factory.createCurrentEdition(),
				newSpawn, launch,
				factory.createSaveEdition(),
				factory.createRemoveEdition(),
				factory.createExtractEdition(),
				factory.createListEdition(),
				factory.createHelpEdition(this));
		
		getEditions().get(launch.getLabel()).setAvailable(true);
		getEditions().get(newSpawn.getLabel()).setAvailable(true);
	}
	
	@Override
	public void onLoaded() {
		for (String label : getEditions().keySet())
			getEditions().get(label).setAvailable(true);
	}
}
