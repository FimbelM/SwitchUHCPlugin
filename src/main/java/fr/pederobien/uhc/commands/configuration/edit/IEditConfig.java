package fr.pederobien.uhc.commands.configuration.edit;

import org.bukkit.command.TabCompleter;

public interface IEditConfig extends TabCompleter {

	boolean edit(String[] args);
	
	String getMessage();
	
	String getEditCommands();
}
