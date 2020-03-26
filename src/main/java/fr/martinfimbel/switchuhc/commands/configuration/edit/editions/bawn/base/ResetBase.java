package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonReset;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class ResetBase extends CommonReset<IBase> {

	public ResetBase() {
		super(MessageCode.RESET_BASE_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_BASE_MESSAGE, name);
	}
}
