package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IMessageCode;

public abstract class CommonLaunch<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonLaunch(IMessageCode explanation) {
		super("launch", explanation);
	}

	protected abstract void onLaunch();

	protected abstract void onNotExist(String name);

	protected abstract void onNeedCoordinates(String name);

	protected abstract void onNeedNameAndCoordinates(String name);

	@Override
	public void edit(String[] args) {
		String name = "";
		if (args.length == 0) {
			get().launch();
			onLaunch();
		} else if (args.length < 2) {
			getPersistence().save();
			try {
				name = args[0];
				getPersistence().load(name).get().launch();
				onLaunch();
			} catch (FileNotFoundException e) {
				onNotExist(name);
			}
		} else if (args.length < 4) {
			try {
				get().setCenter(args[0], args[1], args[2]);
				get().launch();
				onLaunch();
			} catch (IndexOutOfBoundsException e) {
				onNeedCoordinates(name);
			} catch (NumberFormatException e) {
				sendMessage(MessageCode.LAUNCH_BAD_COORDINATES_FORMAT);
			}
		} else {
			name = args[0];
			getPersistence().save();
			try {
				getPersistence().load(name).get().setCenter(args[1], args[2], args[3]);
				get().launch();
				onLaunch();
			} catch (FileNotFoundException e) {
				onNotExist(name);
			} catch (IndexOutOfBoundsException e) {
				onNeedNameAndCoordinates(name);
			} catch (NumberFormatException e) {
				sendMessage(MessageCode.LAUNCH_BAD_COORDINATES_FORMAT);
			}
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = getPersistence().list();
		switch (args.length) {
		case 1:
			if (get() != null)
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
