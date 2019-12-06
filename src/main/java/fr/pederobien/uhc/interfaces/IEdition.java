package fr.pederobien.uhc.interfaces;

import org.bukkit.command.TabCompleter;

public interface IEdition extends TabCompleter {

	String getLabel();

	IMessageCode getExplanation();
}
