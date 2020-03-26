package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonDelete;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class DeleteSpawn extends CommonDelete<ISpawn> {

	public DeleteSpawn() {
		super(MessageCode.DELETE_SPAWN_EXPLANATION);
	}

	@Override
	protected void onDeleted(String name) {
		sendMessage(MessageCode.DELETE_SPAWN_DELETED, name);
	}
}
