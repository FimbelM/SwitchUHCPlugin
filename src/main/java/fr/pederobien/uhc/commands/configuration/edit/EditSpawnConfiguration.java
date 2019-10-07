package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Center;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Current;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Dimensions;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Extract;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Help;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Launch;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.ListSpawn;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.NewSpawn;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Remove;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Rename;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Save;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class EditSpawnConfiguration extends AbstractEditConfiguration implements IEditConfig {
	private SpawnPersistence persistence;
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

	public EditSpawnConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected void setEditions() {
		persistence = new SpawnPersistence();
		
		center = new Center(persistence);
		dimensions = new Dimensions(persistence);
		rename = new Rename(persistence);
		current = new Current(persistence);
		newSpawn = new NewSpawn(persistence);
		launch = new Launch(persistence);
		save = new Save(persistence);
		remove = new Remove(persistence);
		extract = new Extract(persistence);
		list = new ListSpawn(persistence);
		help = new Help(persistence);

		addToMap(center, dimensions, rename, current, newSpawn, launch, save, remove, extract, list, help);
	}
}
