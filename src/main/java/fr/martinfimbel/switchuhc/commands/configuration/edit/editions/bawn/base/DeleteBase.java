package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonDelete;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class DeleteBase extends CommonDelete<IBase> {

	public DeleteBase() {
		super(MessageCode.DELETE_BASE_EXPLANATION);
	}

	@Override
	protected void onDeleted(String name) {
		sendMessage(MessageCode.DELETE_BASE_DELETED, name);
	}
}
