package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IPersistenceEdition;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.interfaces.IWithChildEdition;

public abstract class AbstractMapEdition<T extends IUnmodifiableName> extends AbstractEdition implements IMapEdition<T> {
	private IPersistenceEdition<T> parent;
	private boolean available, unmodifiable;
	private HashMap<String, IMapEdition<T>> editions;

	public AbstractMapEdition(String label, String explanation) {
		super(label, explanation);
		available = true;
		editions = new HashMap<String, IMapEdition<T>>();
	}

	@Override
	public String edit(String[] args) {
		String label = "";
		try {
			label = args[0];
			if (editions.get(label).isAvailable())
				return editions.get(label).edit(Arrays.copyOfRange(args, 1, args.length));
			else
				return "Command " + label + " is not available";
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Cannot run command " + getLabel() + ", arguments are missing";
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "Argument " + label + " is not a valid argument";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
			IMapEdition<T> edition = editions.get(args[0]);
			if (edition != null && edition.isAvailable()) {
				return edition.onTabComplete(sender, command, alias, Arrays.copyOfRange(args, 1, args.length));
			}
			return filter(new ArrayList<String>(
					editions.keySet().stream().filter(l -> editions.get(l).isAvailable()).collect(Collectors.toList())),
					args[0]);
		} catch (IndexOutOfBoundsException e) {
			return emptyList();
		}
	}
	
	@Override
	public String help() {
		String help = super.help() + "\r\n";
		for (IMapEdition<T> edition : editions.values())
			if (edition.isAvailable())
				help += edition.help() + "\r\n";
		return help;
	}
	
	@Override
	public IMapEdition<T> setUnmodifiable(boolean unmodifiable) {
		this.unmodifiable = unmodifiable;
		return this;
	}
	
	@Override
	public boolean isUnmodifiable() {
		return unmodifiable;
	}

	@Override
	public IMapEdition<T> setAvailable(boolean available) {
		if (unmodifiable)
			return this;
		this.available = available;
		for (String label : editions.keySet())
			editions.get(label).setAvailable(available);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public IWithChildEdition<T> addEdition(IMapEdition<T> edition) {
		editions.put(edition.getLabel(), edition);
		edition.setParent(getParent());
		return this;
	}

	@Override
	public IWithChildEdition<T> removeEdition(IMapEdition<T> edition) {
		editions.remove(edition.getLabel());
		edition.setParent(null);
		return this;
	}

	@Override
	public Map<String, IMapEdition<T>> getEditions() {
		return Collections.unmodifiableMap(editions);
	}

	@Override
	public void setParent(IPersistenceEdition<T> parent) {
		if (parent == null)
			return;
		this.parent = parent;
		for (IMapEdition<T> edition : editions.values())
			edition.setParent(parent);
	}
	
	@Override
	public IPersistenceEdition<T> getParent() {
		return parent;
	}

	@Override
	public T get() {
		return parent.get();
	}

	@Override
	public IPersistence<T> getPersistence() {
		return parent.getPersistence();
	}

	protected List<String> emptyList() {
		return new ArrayList<String>();
	}

	protected List<String> filter(Collection<String> list, String filter) {
		return list.stream().filter(str -> str.startsWith(filter)).collect(Collectors.toList());
	}
}
