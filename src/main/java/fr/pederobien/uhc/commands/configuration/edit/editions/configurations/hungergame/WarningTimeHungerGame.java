package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class WarningTimeHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public WarningTimeHungerGame() {
		super("warningtime", "correspond to the time before the game time after which all players "
				+ "in the nether or in the end will be warn that they will die if " + "they stay in the current world");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setWarningTime(LocalTime.parse(args[0]));
			return "Warning time defined : " + showTime(get().getWarningTime());
		} catch (DateTimeParseException e) {
			return "Cannot set the warning time, need the time at format hh:mm:ss";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<hh:mm:ss>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
