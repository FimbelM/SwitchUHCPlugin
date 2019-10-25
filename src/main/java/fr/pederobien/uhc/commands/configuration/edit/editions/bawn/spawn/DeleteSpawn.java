package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.interfaces.ISpawn;

public class DeleteSpawn extends CommonDelete<ISpawn> {

	public DeleteSpawn() {
		super("to delete a spawn");
	}

	@Override
	protected String onDeleted(String name) {
		return "Spawn " + name + " deleted";
	}
}
