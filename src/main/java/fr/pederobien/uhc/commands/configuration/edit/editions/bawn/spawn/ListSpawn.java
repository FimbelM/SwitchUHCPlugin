package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class ListSpawn extends CommonList<ISpawn> {

	public ListSpawn() {
		super(MessageCode.LIST_SPAWN_EXPLANATION);
	}

	@Override
	protected void onSizeEquals0() {
		sendMessage(MessageCode.LIST_SPAWN_SIZE_EQUALS_0);
	}

	@Override
	protected void onSizeEquals1(String name) {
		sendMessage(MessageCode.LIST_SPAWN_SIZE_EQUALS_1, name);
	}

	@Override
	protected void onSizeGreaterThan0(String allNames) {
		sendMessage(MessageCode.LIST_SPAWN_SIZE_GREATER_THAN_0, allNames);
	}
}
