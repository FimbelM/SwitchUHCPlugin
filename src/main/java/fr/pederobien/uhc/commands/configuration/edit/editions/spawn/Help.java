package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Help extends AbstractSpawnEdition {

	public Help(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.HELP);
	}

	@Override
	public String edit(String[] args) {
		try {
			return SpawnEditions.find(args[0]).help();
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			String help = "List of existing commands\r\n";
			for (SpawnEditions edition : SpawnEditions.values()) {
				help += edition.help();
				help += "\r\n";
			}
			return help;
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return filter(SpawnEditions.labels(), subArguments[0]);
		default:
			return null;
		}
	}
}
