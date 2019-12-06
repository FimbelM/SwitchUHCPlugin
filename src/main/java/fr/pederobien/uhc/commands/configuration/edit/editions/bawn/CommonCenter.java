package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBawn;

public class CommonCenter<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonCenter() {
		super("center", MessageCode.CENTER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			get().setCenter(args[0], args[1], args[2]);
			sendMessage(MessageCode.CENTER_DEFINED, "" + get().getCenter().getX(), "" + get().getCenter().getY(), "" + get().getCenter().getZ());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.CENTER_COORDINATES_ARE_MISSING);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.CENTER_BAD_COORDINATES_FORMAT);
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
