package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.interfaces.ISpawn;

public class RandomSpawn extends AbstractBawnEdition<ISpawn> {

	public RandomSpawn() {
		super("random", "to load randomly a spawn");
	}

	@Override
	public String edit(String[] args) {
		List<String> spawns = getPersistence().list();
		String name = spawns.get(new Random().nextInt(spawns.size()));
		try {
			if (get() != null) {
				get().remove();
				getPersistence().save();
			}
			getPersistence().load(name).get().setCenter(args[0], args[1], args[2]);
			get().launch();
			return "Spawn" + name + "launched at " + showBlock(get().getCenter());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Cannot launch randomly spawn " + name + ", spawn does not exist";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot launch randomly a spawn, need center's coordinates <X> <Y> <Z>";
		} catch (NumberFormatException e) {
			return "Cannot parse <X> or <Y> or <Z> argument";
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
