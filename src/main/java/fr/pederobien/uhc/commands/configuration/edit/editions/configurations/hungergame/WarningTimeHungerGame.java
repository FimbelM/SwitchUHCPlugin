package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class WarningTimeHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public WarningTimeHungerGame() {
		super("warningtime", MessageCode.WARNING_TIME_HUNGER_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			get().setWarningTime(LocalTime.parse(args[0]));
			sendMessage(MessageCode.WARNING_TIME_HUNGER_GAME_DEFINED, "" + get().getWarningTime().getHour(), "" + get().getWarningTime().getMinute(),
					"" + get().getWarningTime().getSecond());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.WARNING_TIME_HUNGER_GAME_MISSING_TIME);
		} catch (DateTimeParseException e) {
			sendMessage(MessageCode.BAD_TIME_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<hh:mm:ss>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
