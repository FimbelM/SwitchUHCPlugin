package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn.SpawnEditionsFactory;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.ISpawn;

public class EditSpawnConfiguration extends AbstractEditConfiguration<ISpawn> {
	private static final SpawnEditionsFactory factory = SpawnEditionsFactory.getInstance();

	public EditSpawnConfiguration() {
		super(factory.getPersistence(), "spawn", "to configure a spawn");
		
		IMapEdition<ISpawn> launch = factory.createLaunchEdition();
		IMapEdition<ISpawn> newSpawn = factory.createNewEdition();
		
		addEdition(factory.createCenterEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createDimensionsEdition())
		.addEdition(factory.createExtractEdition())
		.addEdition(factory.createHelpEdition(this))
		.addEdition(launch)
		.addEdition(factory.createListEdition())
		.addEdition(newSpawn)
		.addEdition(factory.createRemoveEdition())
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition());

		getEditions().get(launch.getLabel()).setAvailable(true);
		getEditions().get(newSpawn.getLabel()).setAvailable(true);
	}
	
	/*@Override
	public void onLoaded() {
		availableAll();
	}
	
	@Override
	public void onNewCreated() {
		availableAll();
	}*/
}
