package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class WarningTimeSwitchGame extends AbstractConfEdition<ISwitchGameConfiguration> {
	
	public WarningTimeSwitchGame() {
		super("warningtime", MessageCode.WARNING_TIME_SWITCH_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			get().setWarningTime(LocalTime.parse(args[0]));
			sendMessage(MessageCode.WARNING_TIME_SWITCH_GAME_DEFINED, "" + get().getWarningTime().getHour(), "" + get().getWarningTime().getMinute(),
					"" + get().getWarningTime().getSecond());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.WARNING_TIME_SWITCH_GAME_MISSING_TIME);
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
