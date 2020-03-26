package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class CurrentBase extends AbstractBawnEdition<IBase> {

	public CurrentBase() {
		super("current", MessageCode.CURRENT_BASE_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		sendMessage(MessageCode.CURRENT_BASE_MESSAGE, get().toString());
	}
}
