package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

public interface IHGEdition {
	
	String getLabel();

	String edit(String[] args);
	
	String help();	
}
