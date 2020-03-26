package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.command.TabCompleter;

public interface IEdition extends TabCompleter, Comparable<IEdition> {

	String getLabel();

	IMessageCode getExplanation();
}
