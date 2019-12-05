package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class ListHungerGame extends CommonList<IHungerGameConfiguration> {

	public ListHungerGame() {
		super(MessageCode.LIST_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onSizeEquals0() {
		return MessageCode.LIST_HUNGER_GAME_SIZE_EQUALS_0;
	}

	@Override
	protected MessageCode onSizeEquals1(String name) {
		return MessageCode.LIST_HUNGER_GAME_SIZE_EQUALS_1.withArgs(name);
	}

	@Override
	protected MessageCode onSizeGreaterThan0(String allNames) {
		return MessageCode.LIST_HUNGER_GAME_SIZE_GREATER_THAN_0.withArgs(allNames);
	}
}
