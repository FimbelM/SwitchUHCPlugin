package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.DictionaryManager;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.event.MessageCodeEvent;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IPersistenceEdition;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.observers.IObsMessageCodeSender;

public abstract class AbstractMapEdition<T extends IUnmodifiableName> extends AbstractEdition implements IMapEdition<T> {
	private IPersistenceEdition<T> parent;
	private boolean available, modifiable;
	private HashMap<String, IMapEdition<T>> editions;
	private List<IObsMessageCodeSender> observers;

	public AbstractMapEdition(String label, IMessageCode explanation) {
		super(label, explanation);
		available = true;
		modifiable = true;
		editions = new HashMap<String, IMapEdition<T>>();
		observers = new ArrayList<IObsMessageCodeSender>();
	}

	@Override
	public void edit(String[] args) {
		String label = "";
		try {
			label = args[0];
			if (editions.get(label).isAvailable())
				editions.get(label).edit(Arrays.copyOfRange(args, 1, args.length));
			else
				sendMessage(MessageCode.COMMAND_NOT_AVAILABLE, label);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			sendMessage(MessageCode.CANNOT_RUN_COMMAND, getLabel());
		} catch (NullPointerException e) {
			e.printStackTrace();
			sendMessage(MessageCode.ARGUMENT_NOT_VALID, label);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
			IMapEdition<T> edition = editions.get(args[0]);
			if (edition != null && edition.isAvailable())
				return edition.onTabComplete(sender, command, alias, Arrays.copyOfRange(args, 1, args.length));
			return filter(editions.keySet().stream().filter(l -> editions.get(l).isAvailable()), args[0]);
		} catch (IndexOutOfBoundsException e) {
			return emptyList();
		}
	}

	@Override
	public IMapEdition<T> setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
		return this;
	}

	@Override
	public boolean isModifiable() {
		return modifiable;
	}

	@Override
	public IMapEdition<T> setAvailable(boolean available) {
		if (!modifiable)
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
	public IMapEdition<T> addEdition(IMapEdition<T> edition) {
		editions.put(edition.getLabel(), edition);
		return this;
	}

	@Override
	public IMapEdition<T> removeEdition(IMapEdition<T> edition) {
		editions.remove(edition.getLabel());
		return this;
	}

	@Override
	public Map<String, IMapEdition<T>> getChildren() {
		return Collections.unmodifiableMap(editions);
	}

	@Override
	public void setParent(IPersistenceEdition<T> parent) {
		this.parent = parent;
		for (IMapEdition<T> edition : editions.values())
			edition.setParent(parent);
	}

	@Override
	public IMapEdition<T> addObserver(IObsMessageCodeSender obs) {
		observers.add(obs);
		for (IMapEdition<T> edition : editions.values())
			edition.addObserver(obs);
		return this;
	}

	@Override
	public IMapEdition<T> removeObserver(IObsMessageCodeSender obs) {
		observers.remove(obs);
		for (IMapEdition<T> edition : editions.values())
			edition.removeObserver(obs);
		return this;
	}

	@Override
	public void sendMessage(MessageCodeEvent event) {
		for (IObsMessageCodeSender obs : observers)
			obs.sendMessage(event);
	}

	public T get() {
		return parent.get();
	}

	public IPersistence<T> getPersistence() {
		return parent.getPersistence();
	}

	protected boolean startWithIgnoreCase(String str, String beginning) {
		return str.length() < beginning.length() ? false : str.substring(0, beginning.length()).equalsIgnoreCase(beginning);
	}

	protected String onTabComplete(CommandSender sender, IMessageCode code) {
		return sender instanceof Player ? DictionaryManager.getMessage((Player) sender, code) : null;
	}

	private MessageCodeEvent createMessageCodeEvent(IMessageCode code, String... args) {
		return EventFactory.createMessageCodeEvent(code, args);
	}

	protected void sendMessage(IMessageCode code, String... args) {
		sendMessage(createMessageCodeEvent(code, args));
	}
}
