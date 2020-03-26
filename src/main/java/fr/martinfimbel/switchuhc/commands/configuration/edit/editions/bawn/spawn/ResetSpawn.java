package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonReset;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class ResetSpawn extends CommonReset<ISpawn> {

	public ResetSpawn() {
		super(MessageCode.RESET_SPAWN_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_SPAWN_MESSAGE, name);
	}
}
