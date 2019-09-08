package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class ListSpawn extends AbstractSpawnEdition {

	public ListSpawn(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.LIST);
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
