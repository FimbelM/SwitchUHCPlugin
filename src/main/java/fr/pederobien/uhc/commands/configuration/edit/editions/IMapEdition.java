package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Map;

import org.bukkit.command.TabCompleter;

import fr.pederobien.uhc.observer.IObsPersistence;

public interface IMapEdition extends TabCompleter, IObsPersistence {

	String edit(String[] args);

	String help();

	void addEditions(IMapEdition... editions);

	void removeEdition(String label);
		
	Map<String, IMapEdition> getEditions();

	String getLabel();
	
	String getExplanation();
	
	boolean isAvailable();
	
	IMapEdition setAvailable(boolean available);	
}
