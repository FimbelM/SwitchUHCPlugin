package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class CurrentSwitchGame extends AbstractConfEdition<ISwitchGameConfiguration> {
	public CurrentSwitchGame() {
		super("current",MessageCode.CURRENT_SWITCH_GAME_EXPLANATION);
	}
	@Override
	public void edit(String[] args) {
		sendMessage(MessageCode.CURRENT_SWITCH_GAME_MESSAGE, get().toString());
	}
}
