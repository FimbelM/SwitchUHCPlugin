package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.configurations.ConfigurationsFactory;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonNew<T extends IUnmodifiableName> extends AbstractMapEdition<T> {
	protected ConfigurationsFactory factory = ConfigurationsFactory.getInstance();

	public CommonNew(IMessageCode explanation) {
		super("new", explanation);
	}

	protected abstract void onAlreadyExisting(String name);

	protected abstract void onCreated();

	protected abstract T getNew(String name);

	protected abstract void onNameIsMissing();

	@Override
	public void edit(String[] args) {
		try {
			String name = args[0];
			getPersistence().save();
			if (getPersistence().exist(name))
				onAlreadyExisting(name);
			else if (startWithIgnoreCase(name, "default"))
				sendMessage(MessageCode.NEW_NAME_MUST_NOT_START_BY_DEFAULT, name);
			else {
				getPersistence().set(getNew(name));
				onCreated();
			}
		} catch (IndexOutOfBoundsException e) {
			onNameIsMissing();
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.NEW_NAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
