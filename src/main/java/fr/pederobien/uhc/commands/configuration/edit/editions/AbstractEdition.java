package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.observer.IObsEdition;

public abstract class AbstractEdition<T extends IUnmodifiableName> implements IEdition {
	private IPersistence<T> persistence;
	private String label, explanation;
	private List<IObsEdition> observers;

	public AbstractEdition(IPersistence<T> persistence, String label, String explanation) {
		this.persistence = persistence;
		this.label = label;
		this.explanation = explanation;

		observers = new ArrayList<IObsEdition>();
	}

	@Override
	public String getLabel() {
		return label;
	}
	
	@Override
	public String getExplanation() {
		return explanation;
	}

	@Override
	public String help() {
		return ChatColor.RED + label + ChatColor.RESET + " - " + ChatColor.BLUE + explanation;
	}

	@Override
	public void addObserver(IObsEdition obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(IObsEdition obs) {
		observers.remove(obs);
	}

	protected IPersistence<T> getPersistence() {
		return persistence;
	}

	protected T get() {
		return persistence.get();
	}

	protected List<String> filter(Collection<String> list, String filter) {
		if (list != null) {
			Predicate<String> match = str -> str.matches(filter + "(.*)");
			return list.stream().filter(match).collect(Collectors.toList());
		}
		return emptyList();
	}

	protected void sendMessageToSender(String message) {
		for (IObsEdition obs : observers)
			obs.sendMessage(message);
	}

	protected List<String> emptyList() {
		return new ArrayList<String>();
	}
}
