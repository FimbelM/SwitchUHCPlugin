package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBawn;

public abstract class CommonExtract<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonExtract(MessageCode explanation) {
		super("extract", explanation);
	}

	protected abstract MessageCode onExtracted();

	@Override
	public MessageCode edit(String[] args) {
		get().extract();
		return onExtracted();
	}
}
