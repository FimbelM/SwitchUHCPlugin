package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.conf.IUnmodifiableName;
import fr.pederobien.uhc.persistence.IPersistence;

public abstract class AbstractEdition<T extends IUnmodifiableName> implements IEdition {
	private IPersistence<T> persistence;
	private String label, explanation;

	public AbstractEdition(IPersistence<T> persistence, String label, String explanation) {
		this.persistence = persistence;
		this.label = label;
		this.explanation = explanation;
	}
	
	@Override
	public String getLabel() {
		return label;
	}
	
	@Override
	public String help() {
		return ChatColor.RED + label + ChatColor.RESET + " - " + ChatColor.BLUE + explanation;
	}

	protected IPersistence<T> getPersistence() {
		return persistence;
	}

	protected T get() {
		return persistence.get();
	}

	protected List<String> filter(Collection<String> list, String filter) {
		Predicate<String> match = str -> str.matches(filter + "(.*)");
		return list.stream().filter(match).collect(Collectors.toList());
	}
}
