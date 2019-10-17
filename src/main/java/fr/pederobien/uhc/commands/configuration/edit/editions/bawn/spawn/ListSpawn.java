package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class ListSpawn extends CommonList<ISpawn> {

	public ListSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, "to display all existing spawn(s)");
	}

	@Override
	protected String onSizeGreatThan0() {
		return "List of existing spawn(s) :\n";
	}

	@Override
	protected String onSizeEquals0() {
		return "No existing spawn";
	}
}
