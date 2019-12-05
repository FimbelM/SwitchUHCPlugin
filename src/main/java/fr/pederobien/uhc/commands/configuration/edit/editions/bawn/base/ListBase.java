package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class ListBase extends CommonList<IBase> {

	public ListBase() {
		super(MessageCode.LIST_BASE_EXPLANATION);
	}

	@Override
	protected MessageCode onSizeEquals0() {
		return MessageCode.LIST_BASE_SIZE_EQUALS_0;
	}

	@Override
	protected MessageCode onSizeEquals1(String name) {
		return MessageCode.LIST_BASE_SIZE_EQUALS_1.withArgs(name);
	}

	@Override
	protected MessageCode onSizeGreaterThan0(String allNames) {
		return MessageCode.LIST_BASE_SIZE_GREATER_THAN_0.withArgs(allNames);
	}
}
