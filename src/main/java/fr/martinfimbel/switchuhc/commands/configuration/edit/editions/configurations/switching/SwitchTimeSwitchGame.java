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

public class SwitchTimeSwitchGame extends AbstractConfEdition<ISwitchGameConfiguration> {
	public SwitchTimeSwitchGame() {
		super("switch_time", MessageCode.SWITCH_TIME_SWITCH_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			get().setPeriodSwitchTime(LocalTime.parse(args[0]));
			sendMessage(MessageCode.SWITCH_TIME_SWITCH_GAME_DEFINED, "" + get().getPeriodSwitchTime().getHour(),
					"" + get().getPeriodSwitchTime().getMinute(), "" + get().getPeriodSwitchTime().getSecond());
			return;
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.SWITCH_TIME_SWITCH_GAME_MISSING_TIME);
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
