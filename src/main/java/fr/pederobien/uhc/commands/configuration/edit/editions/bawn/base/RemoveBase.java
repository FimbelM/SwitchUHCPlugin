package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonRemove;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class RemoveBase extends CommonRemove<IBase> {

	public RemoveBase() {
		super(MessageCode.REMOVE_BASE_EXPLANATION);
	}

	@Override
	protected MessageCode onRemove() {
		return MessageCode.REMOVE_BASE_REMOVED.withArgs(get().getName());
	}
}
