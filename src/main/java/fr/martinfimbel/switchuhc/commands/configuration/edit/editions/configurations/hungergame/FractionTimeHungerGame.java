package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class FractionTimeHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public FractionTimeHungerGame() {
		super("fractiontime", MessageCode.FRACTION_TIME_HUNGER_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			get().setFractionTime(LocalTime.parse(args[0]));
			sendMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_DEFINED, "" + get().getFractionTime().getHour(),
					"" + get().getFractionTime().getMinute(), "" + get().getFractionTime().getSecond());
			return;
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.FRACTION_TIME_HUNGER_GAME_MISSING_TIME);
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
