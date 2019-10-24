package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.interfaces.IBawn;

public abstract class CommonRemove<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonRemove(String explanation) {
		super("remove", explanation);
	}

	protected abstract String onRemove();

	@Override
	public String edit(String[] args) {
		get().remove();
		return onRemove();
	}
}
