package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class ListBase extends CommonList<IBase> {

	public ListBase() {
		super(MessageCode.LIST_BASE_EXPLANATION);
	}

	@Override
	protected void onSizeEquals0() {
		sendMessage(MessageCode.LIST_BASE_SIZE_EQUALS_0);
	}

	@Override
	protected void onSizeEquals1(String name) {
		sendMessage(MessageCode.LIST_BASE_SIZE_EQUALS_1, name);
	}

	@Override
	protected void onSizeGreaterThan0(String allNames) {
		sendMessage(MessageCode.LIST_BASE_SIZE_GREATER_THAN_0, allNames);
	}
}
