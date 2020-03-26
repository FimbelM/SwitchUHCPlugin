package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.CommonRemove;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class RemoveSpawn extends CommonRemove<ISpawn> {

	public RemoveSpawn() {
		super(MessageCode.REMOVE_SPAWN_EXPLANATION);
	}

	@Override
	protected void onRemove() {
		sendMessage(MessageCode.REMOVE_SPAWN_REMOVED, get().getName());
	}
}
