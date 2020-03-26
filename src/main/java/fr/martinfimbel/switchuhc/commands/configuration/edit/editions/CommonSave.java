package fr.martinfimbel.switchuhc.commands.configuration.edit.editions;

import fr.martinfimbel.switchuhc.interfaces.IMessageCode;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;

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
