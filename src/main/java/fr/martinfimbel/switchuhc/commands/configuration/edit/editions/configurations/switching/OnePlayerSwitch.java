package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class OnePlayerSwitch extends AbstractConfEdition<ISwitchGameConfiguration> {
	
	public OnePlayerSwitch() {
		super("onePlayerSwitch", MessageCode.ONE_PLAYER_SWITCH_EXPLANATION);
	}
	
	@Override
	public void edit(String[] args) {
		String letter = args[0];
		if(letter.equalsIgnoreCase("Y")) {
			get().setOnePlayerSwitch(letter);
			sendMessage(MessageCode.ONE_PLAYER_SWITCH_DEFINED, get().getReviveNearTeamate());
			return;
		} else if(letter.equalsIgnoreCase("N")) {
			get().setOnePlayerSwitch(letter);
			sendMessage(MessageCode.ONE_PLAYER_SWITCH_DEFINED, get().getReviveNearTeamate());
			return;
		} else {
			sendMessage(MessageCode.ONE_PLAYER_SWITCH_WRONG_FORMAT);
			return;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.ONE_PLAYER_SWITCH_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
