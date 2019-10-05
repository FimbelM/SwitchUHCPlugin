package fr.pederobien.uhc.commands.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.IConfigurationContext;

public abstract class AbstractEditConfiguration implements IEditConfig {
	private String message;
	protected IConfigurationContext context;
	protected HashMap<String, IEdition> map;

	protected abstract void setEditions();

	public AbstractEditConfiguration(IConfigurationContext context) {
		this.context = context;
		map = new HashMap<String, IEdition>();
	}

	@Override
	public boolean edit(String[] args) {
		try {
			setMessage(map.get(args[0]).edit(args));
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
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

	protected void setMessage(String message) {
		this.message = message;
	}

	protected void addToMap(IEdition... editions) {
		for (IEdition edition : editions)
			map.put(edition.getLabel(), edition);
	}
	
	protected List<String> filter(List<String> list, String filter) {
		Predicate<String> match = str -> str.matches(filter + "(.*)");
		return list.stream().filter(match).collect(Collectors.toList());
	}
}
