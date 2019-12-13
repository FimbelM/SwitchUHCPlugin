package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class PlayerSpawn extends AbstractBawnEdition<ISpawn> {

	public PlayerSpawn() {
		super("playerspawn", MessageCode.PLAYER_SPAWN_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			get().setPlayerSpawn(args[0], args[1], args[2]);
			sendMessage(MessageCode.PLAYER_SPAWN_DEFINED, "" + get().getPlayerSpawn().getX(), "" + get().getPlayerSpawn().getY(),
					"" + get().getPlayerSpawn().getZ());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.PLAYER_SPAWN_MISSING_COORDINATES);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.BAD_COORDINATES_FORMAT);
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
