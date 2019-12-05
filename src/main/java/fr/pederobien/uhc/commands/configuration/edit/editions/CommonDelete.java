package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonDelete<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonDelete(MessageCode explanation) {
		super("delete", explanation);
	}

	protected abstract MessageCode onDeleted(String name);

	@Override
	public MessageCode edit(String[] args) {
		String name = args[0];
		if (startWithIgnoreCase(name, "default"))
			return MessageCode.DELETE_ON_CANNOT_DELETE.withArgs(name);
		getPersistence().delete(name);
		if (get() != null && get().getName().equals(name))
			getPersistence().set(null);
		return onDeleted(name);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = getPersistence().list();
		if (get() != null && !list.contains(get().getName()))
			list.add(get().getName());
		return filter(list.stream().filter(l -> !startWithIgnoreCase(l, "default")), args[0]);
	}
}
