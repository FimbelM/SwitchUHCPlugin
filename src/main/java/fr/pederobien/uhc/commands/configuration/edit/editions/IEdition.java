package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import fr.pederobien.uhc.observer.IObsEdition;

public interface IEdition {

	String getLabel();
	
	String getExplanation();

	String edit(String[] args);

	String help();

	List<String> getArguments(String[] subArguments);
	
	void addObserver(IObsEdition obs);
	
	void removeObserver(IObsEdition obs);
}
