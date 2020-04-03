package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class SwitchAfterBorderMoves extends AbstractConfEdition<ISwitchGameConfiguration> {

	public SwitchAfterBorderMoves() {
		super("switchAfterBorderMoves", MessageCode.SWITCH_AFTER_BORDER_MOVES_EXPLANATION);
	}

	@Override
	public void edit(String[] l) {
		String letter = l[0];
		get().setSwitchAfterBorderMoves(letter);
		if (letter.equals("Y")) {
			sendMessage(MessageCode.SWITCH_AFTER_BORDER_MOVES_DEFINED, get().getSwitchAfterBorderMoves());
			return;
		} else if (letter.equals("N")) {
			sendMessage(MessageCode.SWITCH_AFTER_BORDER_MOVES_DEFINED, get().getSwitchAfterBorderMoves());
			return;
		} else {
			sendMessage(MessageCode.SWITCH_AFTER_BORDER_MOVES_WRONG_FORMAT);
			return;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.SWITCH_AFTER_BORDER_MOVES_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
