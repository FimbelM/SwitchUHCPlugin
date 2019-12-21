package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class CurrentBase extends AbstractBawnEdition<IBase> {

	public CurrentBase() {
		super("current", MessageCode.CURRENT_BASE_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		sendMessage(MessageCode.CURRENT_BASE_MESSAGE, get().toString());
	}
}
