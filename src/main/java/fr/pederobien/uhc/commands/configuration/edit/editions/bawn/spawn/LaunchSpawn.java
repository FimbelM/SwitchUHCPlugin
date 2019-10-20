package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.ISpawn;

public class LaunchSpawn extends AbstractBawnEdition<ISpawn> {

	public LaunchSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, "launch", "to launch a spawn in the world");
	}

	@Override
	public String edit(String[] args) {
		if (args.length == 0) {
			get().launch();
			return "Spawn " + get().getName() + " launched at " + showBlock(get().getCenter());
		} else if (args.length < 2) {
			getPersistence().save();
			try {
				getPersistence().load(args[0]);
				get().launch();
				return "Spawn " + get().getName() + " launched at " + showBlock(get().getCenter());
			} catch (FileNotFoundException e) {
				return "Cannot launch spawn " + args[0] + ", spawn does not exist";
			}
		} else if (args.length < 4) {
			try {
				get().setCenter(args[0], args[1], args[2]);
				get().launch();
				return "Spawn " + get().getName() + " launched at " + showBlock(get().getCenter());
			} catch (IndexOutOfBoundsException e) {
				return "Cannot launch spawn " + get().getName() + ", need center's coordinates <X> <Y> <Z>";
			} catch (NumberFormatException e) {
				return "Cannot parse width or height or depth";
			}
		} else {
			getPersistence().save();
			try {
				getPersistence().load(args[0]);
				get().setCenter(args[1], args[2], args[3]);
				get().launch();
				return "Spawn " + get().getName() + " launched at " + showBlock(get().getCenter());
			} catch (FileNotFoundException e) {
				return "Cannot launch spawn " + args[0] + ", spawn does not exist";
			} catch (IndexOutOfBoundsException e) {
				return "Cannot launch spawn " + args[0]
						+ ", need the spawn's name and center's coordinates <X> <Y> <Z>";
			} catch (NumberFormatException e) {
				return "Cannot parse width or height or depth";
			}
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = getPersistence().list();
		switch (args.length) {
		case 1:
			list.add("[<X> <Y> <Z>]");
			if (filter(list, args[0]).isEmpty() && isInteger(args[0]))
				return Arrays.asList("[<X> <Y> <Z>]");
			return filter(list, args[0]);
		}

		if (list.contains(args[0]))
			return onNameIsWritten(args);

		return onNameIsNotWritten(args);
	}

	private boolean isInteger(String arg) {
		if (arg.isEmpty())
			return true;
		try {
			Integer.parseInt(arg);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private List<String> onNameIsWritten(String[] args) {
		switch (args.length) {
		case 2:
			return isInteger(args[1]) ? Arrays.asList("[<X> <Y> <Z>]") : emptyList();
		
		case 3:
			return isInteger(args[1]) && isInteger(args[2]) ? Arrays.asList("<Y> <Z>") : emptyList();

		case 4:
			return isInteger(args[1]) && isInteger(args[2]) && isInteger(args[3]) ? Arrays.asList("<Z>") : emptyList();
		}
		return emptyList();
	}

	private List<String> onNameIsNotWritten(String[] args) {
		switch (args.length) {
		case 2:
			return isInteger(args[0]) && isInteger(args[1]) ? Arrays.asList("<Y> <Z>") : emptyList();

		case 3:
			return isInteger(args[0]) && isInteger(args[1]) && isInteger(args[2]) ? Arrays.asList("<Z>") : emptyList();
		}
		return emptyList();
	}
}
