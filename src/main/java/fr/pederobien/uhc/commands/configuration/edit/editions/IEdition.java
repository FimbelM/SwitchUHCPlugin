package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

public interface IEdition {

	String getLabel();

	String edit(String[] args);

	String help();

	List<String> getArguments(String[] subArguments);
}
