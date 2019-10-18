package fr.pederobien.uhc.commands.configuration.edit;

import java.util.Map;

import org.bukkit.command.TabCompleter;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.observer.IObsEdition;

public interface IEditConfig extends TabCompleter, IObsEdition {

	boolean edit(String[] args);

	String getMessage();

	String help();

	Map<String, IEdition> getEditions();

	void addObserver(IObsEdition obs);

	void removeObserver(IObsEdition obs);
}
