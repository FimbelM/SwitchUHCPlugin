package fr.pederobien.uhc.interfaces;

import org.bukkit.command.TabCompleter;

public interface IEdition extends TabCompleter {

	String edit(String[] args);
	
	String help();
	
	String getLabel();
	
	String getExplanation();
}
