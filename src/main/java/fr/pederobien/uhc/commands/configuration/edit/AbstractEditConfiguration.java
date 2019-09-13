package fr.pederobien.uhc.commands.configuration.edit;

import java.util.HashMap;

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
	public String getEditCommands() {
		return new StringBuilder("Unknown command\r\n").append(getEditionsHelp()).toString();
	}

	@Override
	public String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}

	protected void addToMap(IEdition... editions) {
		for (IEdition edition : editions)
			map.put(edition.getLabel(), edition);
	}

	protected String getEditionsHelp() {
		String help = "List of existing commands\r\n";
		for (String label : map.keySet()) {
			help += map.get(label).help();
			help += "\r\n";
		}
		return help;
	}
}
