package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class InitialBorderDiameterSwitchGame extends AbstractConfEdition<ISwitchGameConfiguration> {
	
	public InitialBorderDiameterSwitchGame() {
	super("initial_border_diameter", MessageCode.INITIAL_BORDER_DIAMETER_SWITCH_GAME_EXPLANATION);
	}
	@Override
	public void edit(String[] args) {
		try {
			int diameter = Integer.parseInt(args[0]);
			if (diameter <= 0) {
				sendMessage(MessageCode.INITIAL_BORDER_NEGATIVE_DIAMETER);
				return;
			}

			get().setInitialBorderDiameter(diameter);
			sendMessage(MessageCode.INITIAL_BORDER_DIAMETER_SWITCH_GAME_DEFINED, get().getInitialBorderDiameter().toString());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.INITIAL_BORDER_DIAMETER_SWITCH_GAME_MISSING_DIAMETER);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.INITIAL_BORDER_DIAMETER_SWITCH_GAME_BAD_DIAMETER_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.INITIAL_BORDER_DIAMETER_SWITCH_GAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}

}
