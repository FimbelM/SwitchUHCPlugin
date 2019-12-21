package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonReset;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class ResetBase extends CommonReset<IBase> {

	public ResetBase() {
		super(MessageCode.RESET_BASE_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_BASE_MESSAGE, name);
	}
}
