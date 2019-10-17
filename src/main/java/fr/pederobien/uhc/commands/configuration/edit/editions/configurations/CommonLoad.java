package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.io.FileNotFoundException;
import java.util.List;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class CommonLoad<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonLoad(IPersistence<T> persistence, String explanation) {
		super(persistence, "load", explanation);
	}
	
	protected abstract String onStyleLoaded();
	
	protected abstract String onNameIsMissing();

	@Override
	public String edit(String[] args) {
		String name = "";
		try {
			name = args[0];
			getPersistence().save();
			getPersistence().load(name);
			return onStyleLoaded();
		} catch (IndexOutOfBoundsException e) {
			return onNameIsMissing();
		} catch (FileNotFoundException e) {
			return "Cannot load style " + name + ", style does not exist";
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return filter(getPersistence().list(), subArguments[0]);
		default:
			return null;
		}
	}
}
