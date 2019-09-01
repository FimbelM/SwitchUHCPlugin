package fr.pederobien.uhc.commands.configuration.edit;

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
}
