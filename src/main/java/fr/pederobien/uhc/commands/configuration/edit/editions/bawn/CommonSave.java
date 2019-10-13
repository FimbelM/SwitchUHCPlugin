package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBawn;

public abstract class CommonSave<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonSave(IPersistence<T> persistence, String explanation) {
		super(persistence, "save", explanation);
	}
	
	protected abstract String onSave();

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return onSave();
	}

}
