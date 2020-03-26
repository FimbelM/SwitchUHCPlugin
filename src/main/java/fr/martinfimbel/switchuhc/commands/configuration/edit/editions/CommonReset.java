package fr.martinfimbel.switchuhc.commands.configuration.edit.editions;

import fr.martinfimbel.switchuhc.interfaces.IMessageCode;
import fr.martinfimbel.switchuhc.interfaces.IResetable;

public abstract class CommonReset<T extends IResetable> extends AbstractMapEdition<T> {

	public CommonReset(IMessageCode explanation) {
		super("reset", explanation);
	}

	protected abstract void onReset(String name);

	@Override
	public void edit(String[] args) {
		get().reset();
		onReset(get().getName());
	}
}
