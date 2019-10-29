package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class PvpTimeHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public PvpTimeHungerGame() {
		super("pvp", "to set the time after which pvp is authorized");
	}
	
	@Override
	public String edit(String[] args) {
		try {
			get().setPvpTime(LocalTime.parse(args[0]));
			return "Pvp time defined : " + showTime(get().getPvpTime());
		} catch (DateTimeParseException e) {
			return "Cannot set the pvp time, need the time at format hh:mm:ss";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<hh:mm:ss>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
