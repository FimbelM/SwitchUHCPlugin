package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Map;

import org.bukkit.command.TabCompleter;

public interface IMapEdition extends TabCompleter {

	String edit(String[] args);

	String help();

	void addEditions(IMapEdition... editions);

	void removeEdition(String label);
	
	Map<String, IMapEdition> getEditions();

	String getLabel();
	
	String getExplanation();
}
