package fr.pederobien.uhc.commands.configuration.edit.editions;

public interface IEdition {

	String getLabel();

	String edit(String[] args);
	
	String help();	
}
