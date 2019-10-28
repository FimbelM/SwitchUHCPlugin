package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.io.FileNotFoundException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public abstract class CommonLoad<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonLoad(String explanation) {
		super("load", explanation);
	}

	protected abstract String onStyleLoaded();

	protected abstract String onNameIsMissing();

	@Override
	public String edit(String[] args) {
		String name = "";
		try {
			name = args[0];
			getPersistence().save();
			getPersistence().load(name);
			return onStyleLoaded();
		} catch (IndexOutOfBoundsException e) {
			return onNameIsMissing();
		} catch (FileNotFoundException e) {
			return "Cannot load style " + name + ", style does not exist";
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
