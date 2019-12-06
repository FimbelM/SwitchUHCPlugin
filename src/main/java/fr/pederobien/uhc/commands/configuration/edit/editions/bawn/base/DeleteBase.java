package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class DeleteBase extends CommonDelete<IBase> {

	public DeleteBase() {
		super(MessageCode.DELETE_BASE_EXPLANATION);
	}

	@Override
	protected void onDeleted(String name) {
		sendMessage(MessageCode.DELETE_BASE_DELETED, name);
	}
}
