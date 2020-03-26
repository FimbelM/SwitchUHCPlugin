package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn;

import fr.martinfimbel.switchuhc.interfaces.IBawn;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

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
