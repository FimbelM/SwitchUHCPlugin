package fr.pederobien.uhc.commands.configuration.edit;

public interface IEditConfig {

	boolean edit(String[] args);
	
	String getMessage();
	
	String getEditCommands();
}
