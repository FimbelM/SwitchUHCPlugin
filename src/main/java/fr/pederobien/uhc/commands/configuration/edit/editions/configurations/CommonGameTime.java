package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMessageCode;

public abstract class CommonGameTime<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonGameTime(IMessageCode explanation) {
		super("gametime", explanation);
	}

	@Override
	public void edit(String[] args) {
		try {
			get().setGameTime(LocalTime.parse(args[0]));
			sendMessage(MessageCode.GAME_TIME_DEFINED, "" + get().getGameTime().getHour(), "" + get().getGameTime().getMinute(),
					"" + get().getGameTime().getSecond());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.GAME_TIME_MISSING_TIME);
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
