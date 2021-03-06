package fr.martinfimbel.switchuhc.commands.configuration.edit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.AbstractEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.event.EventFactory;
import fr.martinfimbel.switchuhc.event.MessageCodeEvent;
import fr.martinfimbel.switchuhc.event.MessageEvent;
import fr.martinfimbel.switchuhc.interfaces.IEditConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IHelper;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;
import fr.martinfimbel.switchuhc.observers.IObsMessageSender;

public class AbstractEditConfiguration<T extends IUnmodifiableName> extends AbstractEdition implements IEditConfiguration<T> {
	private IPersistence<T> persistence;
	private IHelper<T> helper;
	private List<IObsMessageSender> observers;
	private CommandSender sender;
	private HashMap<String, IMapEdition<T>> editions;
	private boolean available, modifiable;

	public AbstractEditConfiguration(IPersistence<T> persistence, String label, MessageCode explanation) {
		super(label, explanation);
		this.persistence = persistence;
		this.persistence.addObserver(this);

		available = true;
		modifiable = true;

		editions = new HashMap<String, IMapEdition<T>>();
		observers = new ArrayList<IObsMessageSender>();

		setHelper(new Helper<T>());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (!isAvailable())
			return emptyList();
		else {
			try {
				String label = args[0];
				IMapEdition<T> edition = editions.get(label);

				if (edition == null) {
					if (label.equals(helper.getLabel()))
						return helper.onTabComplete(sender, command, alias, Arrays.copyOfRange(args, 1, args.length));
					else {
						List<String> labels = editions.keySet().stream().filter(l -> editions.get(l).isAvailable()).collect(Collectors.toList());
						labels.add(helper.getLabel());
						return filter(labels, args[0]);
					}
				}

				return edition.isAvailable() ? edition.onTabComplete(sender, command, alias, Arrays.copyOfRange(args, 1, args.length)) : emptyList();
			} catch (IndexOutOfBoundsException e) {
				return emptyList();
			}
		}
	}

	@Override
	public IPersistence<T> getPersistence() {
		return persistence;
	}

	@Override
	public T get() {
		return persistence.get();
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public IEditConfiguration<T> setAvailable(boolean available) {
		if (!modifiable)
			return this;
		this.available = available;
		for (String label : editions.keySet())
			editions.get(label).setAvailable(available);
		return this;
	}

	@Override
	public boolean isModifiable() {
		return modifiable;
	}

	@Override
	public IEditConfiguration<T> setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
		return this;
	}

	@Override
	public IEditConfiguration<T> addEdition(IMapEdition<T> edition) {
		edition.setAvailable(false);
		edition.setParent(this);
		edition.addObserver(this);
		editions.put(edition.getLabel(), edition);
		return this;
	}

	@Override
	public IEditConfiguration<T> removeEdition(IMapEdition<T> elt) {
		editions.remove(elt.getLabel());
		return this;
	}

	@Override
	public Map<String, IMapEdition<T>> getChildren() {
		return Collections.unmodifiableMap(editions);
	}

	@Override
	public IEditConfiguration<T> addObserver(IObsMessageSender obs) {
		observers.add(obs);
		return this;
	}

	@Override
	public IEditConfiguration<T> removeObserver(IObsMessageSender obs) {
		observers.remove(obs);
		return this;
	}

	@Override
	public void onCurrentChange(T newElt) {
		setAllAvailable(newElt != null);
	}

	@Override
	public void edit(CommandSender sender, String[] args) {
		this.sender = sender;
		String label = "";
		try {
			if (!isAvailable()) {
				sendMessage(MessageCode.COMMAND_NOT_AVAILABLE_YET, getLabel());
				return;
			}
			label = args[0];
			if (label.equals(helper.getLabel()))
				helper.edit(sender, Arrays.copyOfRange(args, 1, args.length));
			else if (editions.get(label).isAvailable())
				editions.get(label).edit(Arrays.copyOfRange(args, 1, args.length));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			sendMessage(MessageCode.CANNOT_RUN_COMMAND, getLabel());
			return;
		} catch (NullPointerException e) {
			e.printStackTrace();
			sendMessage(MessageCode.ARGUMENT_NOT_VALID, label);
		}
	}

	@Override
	public IEditConfiguration<T> setHelper(IHelper<T> helper) {
		this.helper = helper;
		helper.setConfig(this);
		return this;
	}

	@Override
	public void sendMessage(MessageCodeEvent event) {
		MessageEvent messageEvent = EventFactory.createMessageEvent(sender, event);
		for (IObsMessageSender obs : observers)
			obs.sendMessage(messageEvent);
	}

	private void sendMessage(MessageCode code, String... args) {
		MessageEvent event = EventFactory.createMessageEvent(sender, code, args);
		for (IObsMessageSender obs : observers)
			obs.sendMessage(event);
	}

	private void setAllAvailable(boolean available) {
		for (IMapEdition<T> edition : getChildren().values())
			edition.setAvailable(available);
	}
}
