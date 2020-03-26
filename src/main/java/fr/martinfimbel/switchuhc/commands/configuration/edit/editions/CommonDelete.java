package fr.martinfimbel.switchuhc.commands.configuration.edit.editions;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;

public abstract class CommonDelete<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonDelete(IMessageCode explanation) {
		super("delete", explanation);
	}

	protected abstract void onDeleted(String name);

	@Override
	public void edit(String[] args) {
		String name = args[0];
		if (startWithIgnoreCase(name, "default")) {
			sendMessage(MessageCode.DELETE_ON_CANNOT_DELETE, name);
			return;
		}
		getPersistence().delete(name);
		if (get() != null && get().getName().equals(name))
			getPersistence().set(null);
		onDeleted(name);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = getPersistence().list();
		if (get() != null && !list.contains(get().getName()))
			list.add(get().getName());
		return filter(list.stream().filter(l -> !startWithIgnoreCase(l, "default")), args[0]);
	}
}
