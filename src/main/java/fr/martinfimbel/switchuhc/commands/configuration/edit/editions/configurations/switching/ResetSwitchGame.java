package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonReset;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class ResetSwitchGame extends CommonReset<ISwitchGameConfiguration>{
	
	public ResetSwitchGame() {
		super(MessageCode.RESET_SWITCH_GAME_EXPLANATION);
	}
	
	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_SWITCH_GAME_MESSAGE, name);
	}
}
