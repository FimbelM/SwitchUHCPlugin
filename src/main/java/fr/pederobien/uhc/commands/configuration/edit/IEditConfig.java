package fr.pederobien.uhc.commands.configuration.edit;

import java.util.Map;

import org.bukkit.command.TabCompleter;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;

public interface IEditConfig extends TabCompleter {

	boolean edit(String[] args);
	
	String getMessage();
	
	String help();
	
	Map<String, IEdition> getEditions();
}
