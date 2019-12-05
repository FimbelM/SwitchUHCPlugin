package fr.pederobien.uhc.interfaces;

import org.bukkit.command.TabCompleter;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public interface IEdition extends TabCompleter {

	String getLabel();

	MessageCode getExplanation();
}
