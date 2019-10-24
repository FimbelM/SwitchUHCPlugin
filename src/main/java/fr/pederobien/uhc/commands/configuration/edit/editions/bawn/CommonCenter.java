package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IBawn;

public class CommonCenter<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonCenter() {
		super("center", "to set the center");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setCenter(args[0], args[1], args[2]);
			return "Center defined in : " + get().getCenter().getX() + " " + get().getCenter().getY() + " "
					+ get().getCenter().getZ();
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set center's coordinates, need <X> <Y> <Z>";
		} catch (NumberFormatException e) {
			return "Cannot parse <X> or <Y> or <Z> argument";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList("<X> <Y> <Z>");
		case 2:
			return Arrays.asList("<Y> <Z>");
		case 3:
			return Arrays.asList("<Z>");
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
