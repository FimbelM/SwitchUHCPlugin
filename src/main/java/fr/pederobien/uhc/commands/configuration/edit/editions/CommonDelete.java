package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonDelete<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonDelete(String explanation) {
		super("delete", explanation);
	}
	
	protected abstract String onDeleted(String name);
	
	@Override
	public String edit(String[] args) {
		String name = args[0];
		if (name.startsWith("Default"))
			return "Cannot delete " + name;
		getPersistence().delete(name);
		if (get().getName().equals(name))
			getPersistence().set(null);
		return onDeleted(name);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return filter(getPersistence().list().stream().filter(l -> !l.startsWith("Default")).collect(Collectors.toList()), args[0]);
	}
}
