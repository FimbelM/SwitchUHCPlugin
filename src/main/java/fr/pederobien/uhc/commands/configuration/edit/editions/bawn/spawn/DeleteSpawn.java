package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class DeleteSpawn extends CommonDelete<ISpawn> {

	public DeleteSpawn() {
		super(MessageCode.DELETE_SPAWN_EXPLANATION);
	}

	@Override
	protected MessageCode onDeleted(String name) {
		return MessageCode.DELETE_SPAWN_DELETED.withArgs(name);
	}
}
