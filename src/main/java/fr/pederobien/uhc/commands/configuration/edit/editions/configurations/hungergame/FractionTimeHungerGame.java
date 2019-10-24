package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class FractionTimeHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public FractionTimeHungerGame() {
		super("fractiontime", "to set the time after which player will not respawn in survival mode");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setFractionTime(LocalTime.parse(args[0]));
			return "Fraction time defined : " + showTime(get().getFractionTime());
		} catch (IndexOutOfBoundsException | DateTimeParseException e) {
			return "Cannot set the fraction time, need time at format hh:mm:ss";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<hh:mm:ss>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
