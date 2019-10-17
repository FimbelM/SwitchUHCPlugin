package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.configurations.ConfigurationsFactory;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonNew<T extends IUnmodifiableName> extends AbstractEdition<T> {
	protected ConfigurationsFactory factory = ConfigurationsFactory.getInstance();

	public CommonNew(IPersistence<T> persistence, String explanation) {
		super(persistence, "new", explanation);
	}

	protected abstract String onAlreadyExisting(String name);

	protected abstract String onCreated();

	protected abstract T getNew(String name);

	protected abstract String onNameIsMissing();

	@Override
	public String edit(String[] args) {
		try {
			String name = args[0];
			getPersistence().save();
			if (getPersistence().exist(name))
				return onAlreadyExisting(name);
			else {
				getPersistence().set(getNew(name));
				return onCreated();
			}
		} catch (IndexOutOfBoundsException e) {
			return onNameIsMissing();
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<name>");
		default:
			return null;
		}
	}
}
