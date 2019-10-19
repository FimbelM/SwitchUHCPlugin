package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IName;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class CommonRename<T extends IName> extends AbstractEdition<T> {

	public CommonRename(IPersistence<T> persistence, String explanation) {
		super(persistence, "rename", explanation);
	}

	protected abstract String onAlreadyExisting(String newName);

	protected abstract String onRename(String oldName, String newName);

	protected abstract String onNameIsMissing();

	@Override
	public String edit(String[] args) {
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
			return onNameIsMissing();
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<newname>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
