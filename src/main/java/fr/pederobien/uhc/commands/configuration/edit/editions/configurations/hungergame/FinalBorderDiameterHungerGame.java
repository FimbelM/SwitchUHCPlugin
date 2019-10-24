package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class FinalBorderDiameterHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public FinalBorderDiameterHungerGame() {
		super("finalborderdiameter", "to set the final diameter of the world's border");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setFinalBorderDiameter(Integer.parseInt(args[0]));
			return "Final border diameter defined : " + get().getFinalBorderDiameter();
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the final diameter, need diameter";
		} catch (NumberFormatException e) {
			return "Cannot parse final diameter";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<finaldiameter>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
