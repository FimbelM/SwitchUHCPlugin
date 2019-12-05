package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBawn;

public abstract class CommonRemove<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonRemove(MessageCode explanation) {
		super("remove", explanation);
	}

	protected abstract MessageCode onRemove();

	@Override
	public MessageCode edit(String[] args) {
		get().remove();
		return onRemove();
	}
}
