package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.interfaces.IBawn;

public abstract class CommonExtract<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonExtract(String explanation) {
		super("extract", explanation);
	}

	protected abstract String onExtracted();

	@Override
	public String edit(String[] args) {
		get().extract();
		return onExtracted();
	}
}
