package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Help extends AbstractSpawnEdition {

	public Help(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.HELP);
	}

	@Override
	public String edit(String[] args) {
		if (args != null && args.length > 0) {
			SpawnEditions edition = SpawnEditions.find(args[0]);
			if (edition != null)
				return edition.help();
		}
		
		String help = "spawn - List of existing commands\r\n";
		for (SpawnEditions edition : SpawnEditions.values()) {
			help += edition.help();
			help += "\r\n";
		}
		return help;
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
