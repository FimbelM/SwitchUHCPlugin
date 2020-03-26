package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class MovingBorderTimeSwitchGame extends CommonGameTime<ISwitchGameConfiguration> {

	public MovingBorderTimeSwitchGame() {
		super(MessageCode.GAME_TIME_SWITCH_GAME_EXPLANATION);
	}
}
