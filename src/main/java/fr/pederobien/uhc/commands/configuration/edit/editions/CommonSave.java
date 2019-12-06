package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonSave<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonSave(IMessageCode explanation) {
		super("save", explanation);
	}

	protected abstract void onSave();

	@Override
	public void edit(String[] args) {
		getPersistence().save();
		onSave();
	}
}
