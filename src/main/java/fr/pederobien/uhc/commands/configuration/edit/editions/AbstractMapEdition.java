package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractMapEdition implements IMapEdition {
	private HashMap<String, IMapEdition> map;
	private String help, editionsHelp, label, explanation;

	public AbstractMapEdition(String label, String explanation) {
		this.label = label;
		this.explanation = explanation;
		map = new HashMap<String, IMapEdition>();
		help = ChatColor.RED + "label" + " - " + ChatColor.BLUE + explanation;
		editionsHelp = "";
	}

	@Override
	public String edit(String[] args) {
		String label = "";
		try {
			label = args[0];
			return map.get(label).edit(Arrays.copyOfRange(args, 1, args.length));
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Cannot run command " + this.label + ", arguments are missing";
		} catch (NullPointerException e) {
			return "Argument " + label + " is not a valid argument";
		}
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
			System.out.println("On bas completer");
			IMapEdition edition = getEditions().get(args[0]);
			if (edition != null)
				return edition.onTabComplete(sender, command, alias, Arrays.copyOfRange(args, 1, args.length));
			return filter(new ArrayList<String>(getEditions().keySet()), args[0]);
		} catch (IndexOutOfBoundsException e) {
			return emptyList();
		}
	}

	@Override
	public String help() {
		if (editionsHelp.length() == 0)
			return help;
		else
			return editionsHelp;
	}

	@Override
	public void addEditions(IMapEdition... editions) {
		for (IMapEdition edition : editions)
			addEdition(edition);
	}

	@Override
	public void removeEdition(String label) {
		IMapEdition e = map.get(label);
		map.remove(e.getLabel());
	}

	@Override
	public Map<String, IMapEdition> getEditions() {
		return Collections.unmodifiableMap(map);
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getExplanation() {
		return explanation;
	}

	protected List<String> emptyList() {
		return new ArrayList<String>();
	}

	protected List<String> filter(Collection<String> list, String filter) {
		Predicate<String> match = str -> str.matches(filter + "(.*)");
		return list.stream().filter(match).collect(Collectors.toList());
	}

	protected void sendMessageToSender(CommandSender sender, String message) {
		if (sender instanceof Player)
			((Player) sender).sendMessage(message);
	}

	private void addEdition(IMapEdition edition) {
		map.put(edition.getLabel(), edition);
		editionsHelp += edition.help() + "\r\n";
	}
}
