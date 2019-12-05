package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class DeleteBase extends CommonDelete<IBase> {

	public DeleteBase() {
		super(MessageCode.DELETE_BASE_EXPLANATION);
	}

	@Override
	protected MessageCode onDeleted(String name) {
		return MessageCode.DELETE_BASE_DELETED.withArgs(name);
	}
}
