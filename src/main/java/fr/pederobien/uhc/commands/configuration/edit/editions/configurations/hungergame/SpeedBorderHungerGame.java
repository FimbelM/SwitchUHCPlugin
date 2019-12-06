package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class SpeedBorderHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public SpeedBorderHungerGame() {
		super("speedborder", MessageCode.SPEED_BORDER_HUNGER_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			double speed = Double.parseDouble(args[0]);
			if (speed <= 0) {
				sendMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_NEGATIVE);
				return;
			}
			get().setBorderSpeed(speed);
			sendMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_DEFINED, get().getBorderSpeed().toString());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_MISSING_SPEED);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.SPEED_BORDER_HUNGER_GAME_BAD_SPEED_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageOnTabComplete(sender, MessageCode.SPEED_BORDER_HUNGER_GAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
