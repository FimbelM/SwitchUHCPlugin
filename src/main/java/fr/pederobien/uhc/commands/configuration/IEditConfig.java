package fr.pederobien.uhc.commands.configuration;

import org.bukkit.command.TabCompleter;

public interface IEditConfig extends TabCompleter {

	boolean edit(String[] args);
	
	String getMessage();
}
