package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBase;

public class CurrentBase extends AbstractBawnEdition<IBase> {

	public CurrentBase(IPersistence<IBase> persistence) {
		super(persistence, "current", "to know the current spawn's name");
	}

	@Override
	public String edit(String[] args) {
		return "Current base " + get().getName();
	}
}
