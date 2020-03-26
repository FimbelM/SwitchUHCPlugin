package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn;

import fr.martinfimbel.switchuhc.interfaces.IBawn;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public abstract class CommonRemove<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonRemove(IMessageCode explanation) {
		super("remove", explanation);
	}

	protected abstract void onRemove();

	@Override
	public void edit(String[] args) {
		get().remove();
		onRemove();
	}
}
