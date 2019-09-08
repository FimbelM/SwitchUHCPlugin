package fr.pederobien.uhc.commands.configuration.edit;

import java.util.HashMap;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Center;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Current;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Dimensions;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Extract;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Launch;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.ListSpawn;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.NewSpawn;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Remove;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Rename;
import fr.pederobien.uhc.commands.configuration.edit.editions.spawn.Save;
import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class EditSpawnConfiguration extends AbstractEditConfiguration implements IEditConfig {
	private SpawnPersistence persistence;
	private HashMap<String, IEdition> map;
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

	public EditSpawnConfiguration(ConfigurationContext context) {
		super(context);
		persistence = new SpawnPersistence();
		map = new HashMap<String, IEdition>();

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

		addToMap(center, dimensions, rename, current, newSpawn, launch, save, remove, extract, list);
	}

	@Override
	protected void setEditions() {

	}

	@Override
	public boolean edit(String[] args) {
		try {
			setMessage(map.get(args[0]).edit(args));
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			return false;
		}
		return true;
	}

	@Override
	public String getEditCommands() {
		return new StringBuilder("Unknown command\r\n").append(getEditionsHelp()).toString();

	}

	private void addToMap(IEdition... editions) {
		for (IEdition edition : editions)
			map.put(edition.getLabel(), edition);
	}
	
	@Override
	protected String getEditionsHelp() {
		String help = "List of existing commands\r\n";
		for (String label : map.keySet()) {
			help += map.get(label).help();
			help += "\r\n";
		}
		return help;
	}
}
