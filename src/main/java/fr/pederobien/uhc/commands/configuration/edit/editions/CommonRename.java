package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.IName;

public abstract class CommonRename<T extends IName> extends AbstractMapEdition<T> {

	public CommonRename(IMessageCode explanation) {
		super("rename", explanation);
	}

	protected abstract void onAlreadyExisting(String newName);

	protected abstract void onRename(String oldName, String newName);

	protected abstract void onNameIsMissing(String oldName);

	@Override
	public void edit(String[] args) {
		try {
			String newName = args[0];
			if (getPersistence().exist(newName))
				onAlreadyExisting(newName);
			else {
				String oldName = get().getName();
				get().setName(newName);
				onRename(oldName, newName);
			}
		} catch (IndexOutOfBoundsException e) {
			onNameIsMissing(get().getName());
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageOnTabComplete(sender, MessageCode.RENAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
