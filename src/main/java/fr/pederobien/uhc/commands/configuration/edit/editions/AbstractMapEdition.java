package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.DictionaryManager;
import fr.pederobien.uhc.dictionary.NotificationCenter;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IPersistenceEdition;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractMapEdition<T extends IUnmodifiableName> extends AbstractEdition
		implements IMapEdition<T> {
	private IPersistenceEdition<T> parent;
	private boolean available, modifiable;
	private HashMap<String, IMapEdition<T>> editions;

	public AbstractMapEdition(String label, MessageCode explanation) {
		super(label, explanation);
		available = true;
		modifiable = true;
		editions = new HashMap<String, IMapEdition<T>>();
	}

	@Override
	public MessageCode edit(String[] args) {
		String label = "";
		try {
			label = args[0];
			if (editions.get(label).isAvailable())
				return editions.get(label).edit(Arrays.copyOfRange(args, 1, args.length));
			else
				return MessageCode.COMMAND_NOT_AVAILABLE.withArgs(label);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return MessageCode.CANNOT_RUN_COMMAND.withArgs(getLabel());
		} catch (NullPointerException e) {
			e.printStackTrace();
			return MessageCode.ARGUMENT_NOT_VALID.withArgs(label);
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

	public T get() {
		return parent.get();
	}

	public IPersistence<T> getPersistence() {
		return parent.getPersistence();
	}

	protected boolean startWithIgnoreCase(String str, String beginning) {
		return str.length() < beginning.length() ? false
				: str.substring(0, beginning.length()).equalsIgnoreCase(beginning);
	}

	protected String getMessageOnTabComplete(CommandSender sender, MessageCode code) {
		return sender instanceof Player
				? DictionaryManager.getMessage(NotificationCenter.getLocale((Player) sender), code)
				: null;
	}
}
