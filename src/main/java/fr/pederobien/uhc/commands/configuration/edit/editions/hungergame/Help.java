package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Help extends AbstractHGEdition {

	public Help(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, HGEditions.HELP);
	}

	@Override
	public String edit(String[] args) {
		try {
			return HGEditions.find(args[0]).help();
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			String help = "List of existing commands\r\n";
			for (HGEditions edition : HGEditions.values()) {
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
			return filter(HGEditions.labels(), subArguments[0]);
		default:
			return null;
		}
	}
}
