package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.configurations.ConfigurationsFactory;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonNew<T extends IUnmodifiableName> extends AbstractMapEdition<T> {
	protected ConfigurationsFactory factory = ConfigurationsFactory.getInstance();

	public CommonNew(String explanation) {
		super("new", explanation);
	}

	protected abstract String onAlreadyExisting(String name);

	protected abstract String onCreated();

	protected abstract T getNew(String name);

	protected abstract String onNameIsMissing();

	@Override
	public String edit(String[] args) {
		try {
			String name = args[0];
			getPersistence().save();
			if (getPersistence().exist(name))
				return onAlreadyExisting(name);
			else if (startWithIgnoreCase(name, "default"))
				return name + " must not start with default (ignoring case)";
			else {
				getPersistence().set(getNew(name));
				return onCreated();
			}
		} catch (IndexOutOfBoundsException e) {
			return onNameIsMissing();
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList("<name>");
		return super.onTabComplete(sender, command, alias, args);
	}
}
