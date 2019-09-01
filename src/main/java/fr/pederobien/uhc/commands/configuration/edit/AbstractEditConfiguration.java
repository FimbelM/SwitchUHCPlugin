package fr.pederobien.uhc.commands.configuration.edit;

public abstract class AbstractEditConfiguration implements IEditConfig {
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}
}
