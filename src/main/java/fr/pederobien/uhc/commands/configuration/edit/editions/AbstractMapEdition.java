package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistenceEdition;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.interfaces.IWithChildEdition;

public class AbstractMapEdition<T extends IUnmodifiableName> extends AbstractEdition implements IMapEdition<T> {

	public AbstractMapEdition(String label, String explanation) {
		super(label, explanation);
	}

	@Override
	public String edit(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAvailable(boolean available) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IWithChildEdition<T> addEdition(IMapEdition<T> edition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWithChildEdition<T> removeEdition(IMapEdition<T> edition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(IPersistenceEdition<T> parent) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public String edit(String[] args) {
		String label = "";
		try {
			label = args[0];
			if (map.get(label).isAvailable())
				return map.get(label).edit(Arrays.copyOfRange(args, 1, args.length));
			else
				return "Command " + label + " is not available";
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Cannot run command " + this.label + ", arguments are missing";
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "Argument " + label + " is not a valid argument";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
			IMapEdition edition = getEditions().get(args[0]);
			if (edition != null && edition.isAvailable()) {
				return edition.onTabComplete(sender, command, alias, Arrays.copyOfRange(args, 1, args.length));
			}
			return filter(new ArrayList<String>(
					getEditions().keySet().stream().filter(l -> map.get(l).isAvailable()).collect(Collectors.toList())),
					args[0]);
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

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public IMapEdition setAvailable(boolean available) {
		this.available = available;
		for (String label : map.keySet())
			map.get(label).setAvailable(available);
		return this;
	}

	@Override
	public void onBeforeLaunching() {

	}

	@Override
	public void onLoaded() {

	}

	@Override
	public void onNewCreated() {

	}

	protected <T> List<T> emptyList() {
		return new ArrayList<T>();
	}

	protected List<String> filter(Collection<String> list, String filter) {
		return list.stream().filter(str -> str.matches(filter + "(.*)")).collect(Collectors.toList());
	}

	protected void sendMessageToSender(CommandSender sender, String message) {
		if (sender instanceof Player)
			((Player) sender).sendMessage(message);
	}

	private void addEdition(IMapEdition edition) {
		map.put(edition.getLabel(), edition);
		editionsHelp += edition.help() + "\r\n";
	}*/
}
