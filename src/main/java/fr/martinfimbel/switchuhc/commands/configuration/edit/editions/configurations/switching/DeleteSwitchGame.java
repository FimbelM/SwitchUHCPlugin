package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonDelete;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class DeleteSwitchGame extends CommonDelete<ISwitchGameConfiguration>{
	public DeleteSwitchGame() {
		super(MessageCode.DELETE_SWITCH_GAME_EXPLANATION);
	}
	@Override
	protected void onDeleted(String name) {
		sendMessage(MessageCode.DELETE_SWITCH_GAME_MESSAGE, name);
	}
}
