package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class BaseDistanceBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public BaseDistanceBlockedexGame() {
		super("basedistance", "to set the distance between each base's center and spawn's center");
	}

	@Override
	public String edit(String[] args) {
		int distance;
		try {
			distance = Integer.parseInt(args[0]);
			get().setBaseFromSpawnDistance(distance);
			return "Base - Spawn distance defined as " + get().getBaseFromSpawnDistance() + " blocks";
		} catch (NumberFormatException e) {
			return "Cannot set the distance, argument should be an integer";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the distance, need the distance";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<distance>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
