package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IMessageCode;

public abstract class CommonExtract<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonExtract(IMessageCode explanation) {
		super("extract", explanation);
	}

	protected abstract void onExtracted();

	@Override
	public void edit(String[] args) {
		get().extract();
		onExtracted();
	}
}
