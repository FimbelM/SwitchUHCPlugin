package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class RandomSpawn extends AbstractBawnEdition<ISpawn> {

	public RandomSpawn() {
		super("random", MessageCode.RANDOM_SPAWN_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		List<String> spawns = getPersistence().list();
		String name = spawns.get(new Random().nextInt(spawns.size()));
		try {
			if (get() != null) {
				get().remove();
				getPersistence().save();
			}
			getPersistence().load(name).get().setCenter(args[0], args[1], args[2]);
			get().launch();
			sendMessage(MessageCode.RANDOM_SPAWN_LAUNCHED, name, "" + get().getCenter().getX(), "" + get().getCenter().getY(),
					"" + get().getCenter().getZ());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			sendMessage(MessageCode.RANDOM_SPAWN_CANNOT_BE_LAUNCHED, name);
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.RANDOM_SPAWN_MISSING_COORDINATES);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.BAD_COORDINATES_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList("[<X> <Y> <Z>]");
		case 2:
			return Arrays.asList("<Y> <Z>");
		case 3:
			return Arrays.asList("<Z>");
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
