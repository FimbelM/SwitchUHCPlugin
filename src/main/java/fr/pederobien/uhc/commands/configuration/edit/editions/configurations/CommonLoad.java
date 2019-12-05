package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.io.FileNotFoundException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public abstract class CommonLoad<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonLoad(MessageCode explanation) {
		super("load", explanation);
	}

	protected abstract MessageCode onStyleLoaded(String name);

	protected abstract MessageCode onNameIsMissing();

	@Override
	public MessageCode edit(String[] args) {
		String name = "";
		try {
			name = args[0];
			getPersistence().save();
			getPersistence().load(name);
			return onStyleLoaded(name);
		} catch (IndexOutOfBoundsException e) {
			return onNameIsMissing();
		} catch (FileNotFoundException e) {
			return MessageCode.LOAD_CANNOT_LOAD.withArgs(name);
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
