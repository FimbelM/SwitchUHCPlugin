package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.io.FileNotFoundException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.managers.ETeam;

public abstract class CommonLoad<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonLoad(IMessageCode explanation) {
		super("load", explanation);
	}

	protected abstract void onStyleLoaded(String name);

	protected abstract void onNameIsMissing();

	@Override
	public void edit(String[] args) {
		String name = "";
		try {
			name = args[0];
			getPersistence().save();
			getPersistence().load(name);
			onStyleLoaded(name);
		} catch (IndexOutOfBoundsException e) {
			onNameIsMissing();
		} catch (FileNotFoundException e) {
			sendMessage(MessageCode.LOAD_CANNOT_LOAD, name);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getPersistence().list(), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}

	protected String getTeamNamesWithColor() {
		String names = "";
		for (ETeam team : get().getTeams())
			names += team.getNameWithColor() + " ";
		return names;
	}
}
