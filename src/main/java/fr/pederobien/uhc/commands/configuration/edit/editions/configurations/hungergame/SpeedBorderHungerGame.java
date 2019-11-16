package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class SpeedBorderHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public SpeedBorderHungerGame() {
		super("speedborder", "to change the speed when the border is moving");
	}
	
	@Override
	public String edit(String[] args) {
		try {
			double speed = Double.parseDouble(args[0]);
			if (speed <= 0)
				return "The speed must strictly positive";
			get().setBorderSpeed(speed);
			return "The border speed defined as " + get().getBorderSpeed() + " blocks per second";
		} catch (NumberFormatException e) {
			return "Speed must be a double value (example : 1.5)";
		}
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<blocks per second>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
