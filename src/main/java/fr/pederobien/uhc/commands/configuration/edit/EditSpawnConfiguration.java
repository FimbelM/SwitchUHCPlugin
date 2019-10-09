package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.SpawnEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;

public class EditSpawnConfiguration extends AbstractEditConfiguration<ISpawn> {
	private IEdition center;
	private IEdition dimensions;
	private IEdition rename;
	private IEdition current;
	private IEdition newSpawn;
	private IEdition launch;
	private IEdition save;
	private IEdition remove;
	private IEdition extract;
	private IEdition list;
	private IEdition help;

	private SpawnEditionsFactory factory;

	public EditSpawnConfiguration(IConfigurationContext context) {
		super(context);
		factory = SpawnEditionsFactory.getInstance();
	}

	@Override
	protected void setEditions() {
		center = factory.createCenterEdition();
		dimensions = factory.createDimensionsEdition();
		rename = factory.createRenameEdition();
		current = factory.createCurrentEdition();
		newSpawn = factory.createNewSpawnEdition();
		launch = factory.createLaunchEdition();
		save = factory.createSaveEdition();
		remove = factory.createRemoveEdition();
		extract = factory.createExtractEdition();
		list = factory.createListEdition();
		help = factory.createHelpEdition();

		addToMap(center, dimensions, rename, current, newSpawn, launch, save, remove, extract, list, help);
	}
}
