package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBawn;

public abstract class CommonExtract<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonExtract(IPersistence<T> persistence, String explanation) {
		super(persistence, "extract", explanation);
	}
	
	protected abstract String onExtracted();

	@Override
	public String edit(String[] args) {
		get().extract();
		return onExtracted();
	}
}
