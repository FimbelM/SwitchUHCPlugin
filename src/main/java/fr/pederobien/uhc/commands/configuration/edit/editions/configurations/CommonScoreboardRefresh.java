package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IConfiguration;

public class CommonScoreboardRefresh<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonScoreboardRefresh() {
		super("scoreboardrefresh",
				"to set the number of servers's tic after which the scoreboard of each player is refreshed");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setScoreboardRefresh(Long.parseLong(args[0]));
			return "Scoreboard refreshed each " + get().getScoreboardRefresh() + " tics";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the scoreboard refrresh value, need a number of tics";
		} catch (NumberFormatException e) {
			return "Cannot parse number of tics";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<number of tics>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
