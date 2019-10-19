package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import java.io.FileNotFoundException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;

public class LoadBaseTemp extends AbstractBawnEdition<IBase> {

	public LoadBaseTemp(IPersistence<IBase> persistence) {
		super(persistence, "load", "to load a base");
	}

	@Override
	public String edit(String[] args) {
		String name = "";
		try {
			name = args[0];
			getPersistence().save();
			getPersistence().load(name);
			return "Base " + name + " loaded";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot load base, need the name";
		} catch (FileNotFoundException e) {
			return "Cannot load base " + name + ", base does not exist";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getPersistence().list(), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}
}
