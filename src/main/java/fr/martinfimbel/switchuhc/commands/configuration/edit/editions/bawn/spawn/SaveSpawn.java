package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonSave;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class SaveSpawn extends CommonSave<ISpawn> {

	public SaveSpawn() {
		super(MessageCode.SAVE_SPAWN_EXPLANATION);
	}

	@Override
	protected void onSave() {
		sendMessage(MessageCode.SAVE_SPAWN_SAVED, get().getName());
	}
}
