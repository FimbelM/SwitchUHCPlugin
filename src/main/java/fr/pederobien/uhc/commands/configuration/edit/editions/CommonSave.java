package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonSave<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonSave(String explanation) {
		super("save", explanation);
	}

	protected abstract String onSave();

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return onSave();
	}
}
