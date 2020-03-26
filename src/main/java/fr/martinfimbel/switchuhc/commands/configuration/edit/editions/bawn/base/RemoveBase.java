package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.CommonRemove;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class RemoveBase extends CommonRemove<IBase> {

	public RemoveBase() {
		super(MessageCode.REMOVE_BASE_EXPLANATION);
	}

	@Override
	protected void onRemove() {
		sendMessage(MessageCode.REMOVE_BASE_REMOVED, get().getName());
	}
}
