package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class ListSpawn extends AbstractSpawnEdition {

	public ListSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.LIST);
	}

	@Override
	public String edit(String[] args) {
		StringBuilder builder = new StringBuilder();
		List<String> list = getPersistence().list();
		if (list.size() > 0)
			builder.append("List of existing spawn(s) :\n");
		else
			builder.append("No existing spawn");

		for (String str : list)
			builder.append(str.concat("\n"));
		return builder.toString();
	}
}
