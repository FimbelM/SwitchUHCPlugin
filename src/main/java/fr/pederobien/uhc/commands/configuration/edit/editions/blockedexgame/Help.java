package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;

public class Help extends AbstractBDEdition {

	public Help(BlockedexPersistence persistence) {
		super(persistence, BDEditions.HELP);
	}

	@Override
	public String edit(String[] args) {
		try {
			return BDEditions.find(args[0]).help();
		} catch (IndexOutOfBoundsException | NullPointerException e){
			String help = "List of existing commands\r\n";
			for (BDEditions edition : BDEditions.values()) {
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
			return filter(BDEditions.labels(), subArguments[0]);
		default:
			return null;
		}
	}
}
