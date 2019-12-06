package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;

public class CommonScoreboardRefresh<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonScoreboardRefresh() {
		super("scoreboardrefresh", MessageCode.SCOREBOARD_REFRESH_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			long refresh = Long.parseLong(args[0]);
			if (refresh < 0)
				sendMessage(MessageCode.SCOREBOARD_REFRESH_NEGATIVE_TIC_DEFINED);
			if (refresh == 1) {
				get().setScoreboardRefresh(refresh);
				sendMessage(MessageCode.SCOREBOARD_REFRESH_ONE_TIC_DEFINED);
			} else {
				get().setScoreboardRefresh(refresh);
				sendMessage(MessageCode.SCOREBOARD_REFRESH_TICS_DEFINED, "" + refresh);
			}
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.SCOREBOARD_REFRESH_MISSING_TICS);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.SCOREBOARD_REFRESH_BAD_TICS_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageOnTabComplete(sender, MessageCode.SCOREBOARD_REFRESH_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
