package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonList;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class ListSwitchGame extends CommonList<ISwitchGameConfiguration> {

	public ListSwitchGame() {
		super(MessageCode.LIST_SWITCH_GAME_EXPLANATION);
	}

	@Override
	protected void onSizeEquals0() {
		sendMessage(MessageCode.LIST_SWITCH_GAME_SIZE_EQUALS_0);
	}

	@Override
	protected void onSizeEquals1(String name) {
		sendMessage(MessageCode.LIST_SWITCH_GAME_SIZE_EQUALS_1, name);
	}

	@Override
	protected void onSizeGreaterThan0(String allNames) {
		sendMessage(MessageCode.LIST_SWITCH_GAME_SIZE_GREATER_THAN_0, allNames);
	}
}
