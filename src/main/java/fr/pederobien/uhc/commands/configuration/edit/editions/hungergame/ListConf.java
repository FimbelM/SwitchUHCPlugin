package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class ListConf extends AbstractHGEdition {

	public ListConf(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, HGEditions.LIST);
	}

	@Override
	public String edit(String[] args) {
		StringBuilder builder = new StringBuilder();
		List<String> list = getPersistence().list();
		if (list.size() > 0)
			builder.append("List of existing hunger game style (s) :\n");
		else
			builder.append("No existing hunger game style");

		for (String str : list)
			builder.append(str.concat("\n"));
		return builder.toString();
	}
}
