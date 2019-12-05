package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonSave<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonSave(MessageCode explanation) {
		super("save", explanation);
	}

	protected abstract MessageCode onSave();

	@Override
	public MessageCode edit(String[] args) {
		getPersistence().save();
		return onSave();
	}
}
