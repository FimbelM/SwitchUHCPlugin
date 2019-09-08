package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

import java.util.List;

public class ListConf extends AbstractHGEdition {

	public ListConf(HungerGamePersistence persistence) {
		super(persistence, HGEditions.LIST);
	}

	@Override
	public String edit(String[] args) {
		return prepare(getPersistence().list(), "spawn");
	}
	
	protected String prepare(List<String> list, String elt) {
		StringBuilder builder = new StringBuilder();
		if (list.size() > 0)
			builder.append("List of existing " + elt + "(s) :\n");
		else
			builder.append("No existing " + elt);
		
		for (String str : list)
			builder.append(str.concat("\n"));
		return builder.toString();
	}
}
