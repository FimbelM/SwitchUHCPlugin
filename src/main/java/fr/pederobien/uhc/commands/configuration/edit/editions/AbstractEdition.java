package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.observer.IObsEdition;

public abstract class AbstractEdition<T extends IUnmodifiableName> extends AbstractMapEdition implements IEdition {
	private IPersistence<T> persistence;
	private List<IObsEdition> observers;

	public AbstractEdition(IPersistence<T> persistence, String label, String explanation) {
		super(label, explanation);
		this.persistence = persistence;

		observers = new ArrayList<IObsEdition>();
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return null;
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
