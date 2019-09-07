package fr.pederobien.uhc.commands.configuration.edit;

import java.util.ArrayList;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.ConfigurationContext;

public abstract class AbstractEditConfiguration implements IEditConfig {
	private String message;
	protected ConfigurationContext context;
	protected List<Edition> editions;
	
	protected abstract void setEditions();
	
	public AbstractEditConfiguration(ConfigurationContext context) {
		this.context = context;
		editions = new ArrayList<Edition>();
		setEditions();
	}

	@Override
	public String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}
	
	protected String prepare(List<String> list, String elt) {
		StringBuilder builder = new StringBuilder();
		if (list.size() > 0)
			builder.append("List of existing " + elt + "(s) :\n");
		else
			builder.append("No existing " + elt);
		
		for (String str : list)
			builder.append(str.concat("\n"));
		return builder.toString();
	}
	
	protected Edition getEdition(String label) {
		for (Edition edition : editions) {
			if (edition.getLabel().equals(label))
				return edition;
		}
		return null;
	}
	
	protected String getEditionsHelp() {
		String toString = "List of existing commands\r\n";
		for (Edition edition : editions) {
			toString += edition.help();
			toString += "\r\n";
		}
		return toString;
	}
}
