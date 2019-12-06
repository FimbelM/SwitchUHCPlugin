package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IMessageCode;

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
