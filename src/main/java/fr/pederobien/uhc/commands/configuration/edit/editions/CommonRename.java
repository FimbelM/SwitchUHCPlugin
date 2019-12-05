package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IName;

public abstract class CommonRename<T extends IName> extends AbstractMapEdition<T> {

	public CommonRename(MessageCode explanation) {
		super("rename", explanation);
	}

	protected abstract MessageCode onAlreadyExisting(String newName);

	protected abstract MessageCode onRename(String oldName, String newName);

	protected abstract MessageCode onNameIsMissing(String oldName);

	@Override
	public MessageCode edit(String[] args) {
		try {
			String newName = args[0];
			if (getPersistence().exist(newName))
				return onAlreadyExisting(newName);
			else {
				String oldName = get().getName();
				get().setName(newName);
				return onRename(oldName, newName);
			}
		} catch (IndexOutOfBoundsException e) {
			return onNameIsMissing(get().getName());
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageOnTabComplete(sender, MessageCode.RENAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
