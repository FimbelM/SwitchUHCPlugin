package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.CommonAsCurrent;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class AsCurrentSwitchGame extends CommonAsCurrent<ISwitchGameConfiguration> {
	
	public AsCurrentSwitchGame(IConfigurationContext context) {
		super(context, MessageCode.AS_CURRENT_SWITCH_GAME_EXPLANATION);
	}

	@Override
	protected void onStyleNotDefined(String name) {
		// TODO Auto-generated method stub
		sendMessage(MessageCode.AS_CURRENT_SWITCH_GAME_NOT_EXISTING_STYLE, name);
	}

}
