package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class NumberOfPlayerSwitchable extends AbstractConfEdition<ISwitchGameConfiguration> {
	public NumberOfPlayerSwitchable() {
		super("NumberOfSwitchablePlayerPerTeam", MessageCode.NUMBER_OF_SWITCHABLE_PLAYER_PER_TEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			int number = Integer.parseInt(args[0]);
					if(number<1) {
						sendMessage(MessageCode.NUMBER_OF_SWITCHED_PLAYERS_INFERIOR_AT_ONE);
						return;
					}
			get().setNumberOfPlayerSwitchable(Integer.parseInt(args[0]));
			sendMessage(MessageCode.NUMBER_OF_SWITCHABLE_PLAYER_PER_TEAM_DEFINED, "" + get().getNumberOfPlayerSwitchable());
			return;
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.NUMBER_OF_SWITCHABLE_PLAYER_PER_TEAM_MISSING_NUMBER);
		} catch(NumberFormatException e) {
			sendMessage(MessageCode.NUMBER_OF_SWITCHABLE_PLAYER_PER_TEAM_BAD_FORMAT);
		}
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<Number>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
