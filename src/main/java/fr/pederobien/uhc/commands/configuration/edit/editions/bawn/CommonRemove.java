package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBawn;

public abstract class CommonRemove<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonRemove(IPersistence<T> persistence, String explanation) {
		super(persistence, "remove", explanation);
	}
	
	protected abstract String onRemove();

	@Override
	public String edit(String[] args) {
		get().remove();
		return onRemove();
	}
}
