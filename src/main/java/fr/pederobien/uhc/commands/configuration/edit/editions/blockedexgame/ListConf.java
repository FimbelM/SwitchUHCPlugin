package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;

public class ListConf extends AbstractBDEdition {

	public ListConf(BlockedexPersistence persistence) {
		super(persistence, BDEditions.LIST);
	}

	@Override
	public String edit(String[] args) {
		StringBuilder builder = new StringBuilder();
		List<String> list = getPersistence().list();
		if (list.size() > 0)
			builder.append("List of existing blockedex game style (s) :\n");
		else
			builder.append("No existing blockedex game style");

		for (String str : list)
			builder.append(str.concat("\n"));
		return builder.toString();
	}
}
