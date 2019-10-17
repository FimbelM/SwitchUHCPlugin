package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonSave<T extends IUnmodifiableName> extends AbstractEdition<T> {

	public CommonSave(IPersistence<T> persistence, String explanation) {
		super(persistence, "save", explanation);
	}

	protected abstract String onSave();

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return onSave();
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		return null;
	}
}
