package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonSave;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class SaveSwitchGame extends CommonSave<ISwitchGameConfiguration>{

	public SaveSwitchGame() {
		super(MessageCode.SAVE_SWITCH_GAME_EXPLANATION);
	}
	
	@Override
	protected void onSave() {
		sendMessage(MessageCode.SAVE_SWITCH_GAME_SAVED, get().getName());
	}
}
