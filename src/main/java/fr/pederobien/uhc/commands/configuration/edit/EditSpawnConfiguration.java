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
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

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

	public EditSpawnConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected IPersistence<ISpawn> getPersistenceImpl() {
		return ConfigurationsFactory.getInstance().getSpawnPersistence();
	}

	@Override
	protected void setEditions() {
		center = new Center(getPersistence());
		dimensions = new Dimensions(getPersistence());
		rename = new Rename(getPersistence());
		current = new Current(getPersistence());
		newSpawn = new NewSpawn(getPersistence());
		launch = new Launch(getPersistence());
		save = new Save(getPersistence());
		remove = new Remove(getPersistence());
		extract = new Extract(getPersistence());
		list = new ListSpawn(getPersistence());
		help = new Help(getPersistence());

		addToMap(center, dimensions, rename, current, newSpawn, launch, save, remove, extract, list, help);
	}
}
