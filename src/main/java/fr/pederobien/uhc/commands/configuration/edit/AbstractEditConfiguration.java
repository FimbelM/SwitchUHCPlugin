package fr.pederobien.uhc.commands.configuration.edit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractEditConfiguration<T extends IUnmodifiableName> implements IEditConfig {
	protected IConfigurationContext context;
	private HashMap<String, IEdition> map;
	private String message, help;

	public AbstractEditConfiguration(IConfigurationContext context) {
		this.context = context;
		map = new HashMap<String, IEdition>();
		help = "";
		setEditions();
	}

	protected abstract void setEditions();

	@Override
	public boolean edit(String[] args) {
		try {
			setMessage(map.get(args[0]).edit(Arrays.copyOfRange(args, 1, args.length)));
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		IEdition edition = map.get(args[0]);
		if (edition != null)
			return edition.getArguments(Arrays.copyOfRange(args, 1, args.length));
		return filter(new ArrayList<String>(map.keySet()), args[0]);
	}
	
	@Override
	public String help() {
		return help;
	}
	
	@Override
	public Map<String, IEdition> getEditions() {
		return Collections.unmodifiableMap(map);
	}

	protected void setMessage(String message) {
		this.message = message;
	}

	protected void addToMap(IEdition... editions) {
		for (IEdition edition : editions) {
			map.put(edition.getLabel(), edition);
			help += edition.help() + "\r\n";
		}
	}

	protected List<String> filter(List<String> list, String filter) {
		Predicate<String> match = str -> str.matches(filter + "(.*)");
		return list.stream().filter(match).collect(Collectors.toList());
	}
}
