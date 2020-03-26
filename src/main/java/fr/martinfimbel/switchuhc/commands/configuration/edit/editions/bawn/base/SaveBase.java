package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonSave;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class SaveBase extends CommonSave<IBase> {

	public SaveBase() {
		super(MessageCode.SAVE_BASE_EXPLANATION);
	}

	@Override
	protected void onSave() {
		sendMessage(MessageCode.SAVE_BASE_SAVED);
	}
}
