package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class BorderCenterSwitchGame extends AbstractConfEdition<ISwitchGameConfiguration> {
	public BorderCenterSwitchGame() {
		super("bordercenter", MessageCode.BORDER_CENTER_SWITCH_GAME_EXPLANATION);
	}
	
	@Override
	public void edit(String[] args) {
		try {
			get().setBorderCenter(args[0], args[1]);
			sendMessage(MessageCode.BORDER_CENTER_SWITCH_GAME_DEFINED, get().getBorderCenter().getX() + " " + get().getBorderCenter().getZ());
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			sendMessage(MessageCode.BORDER_CENTER_SWITCH_GAME_MISSING_COORDINATES);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.BAD_COORDINATES_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList("<X> <Z>");
		case 2:
			return Arrays.asList("<Z>");
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
