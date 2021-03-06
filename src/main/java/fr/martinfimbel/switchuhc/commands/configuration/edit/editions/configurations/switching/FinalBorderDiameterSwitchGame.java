package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class FinalBorderDiameterSwitchGame extends AbstractConfEdition<ISwitchGameConfiguration> {

	public FinalBorderDiameterSwitchGame() {
		super("finalborderdiameter", MessageCode.FINAL_BORDER_DIAMETER_SWITCH_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			int diameter = Integer.parseInt(args[0]);
			if (diameter <= 0) {
				sendMessage(MessageCode.FINAL_BORDER_NEGATIVE_DIAMETER);
				return;
			}

			get().setFinalBorderDiameter(diameter);
			sendMessage(MessageCode.FINAL_BORDER_DIAMETER_SWITCH_GAME_DEFINED, get().getFinalBorderDiameter().toString());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.FINAL_BORDER_DIAMETER_SWITCH_GAME_MISSING_DIAMETER);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.FINAL_BORDER_DIAMETER_SWITCH_GAME_BAD_DIAMETER_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.FINAL_BORDER_DIAMETER_SWITCH_GAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
