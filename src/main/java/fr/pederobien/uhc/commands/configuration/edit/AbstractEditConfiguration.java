package fr.pederobien.uhc.commands.configuration.edit;

import java.util.List;

import fr.pederobien.uhc.conf.configurations.ConfigurationContext;

public abstract class AbstractEditConfiguration implements IEditConfig {
	private String message;
	protected ConfigurationContext context;
	
	public AbstractEditConfiguration(ConfigurationContext context) {
		this.context = context;
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
}
