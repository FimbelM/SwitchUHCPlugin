package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class SaveSpawn extends CommonSave<ISpawn> {

	public SaveSpawn() {
		super(MessageCode.SAVE_SPAWN_EXPLANATION);
	}

	@Override
	protected void onSave() {
		sendMessage(MessageCode.SAVE_SPAWN_SAVED, get().getName());
	}
}
