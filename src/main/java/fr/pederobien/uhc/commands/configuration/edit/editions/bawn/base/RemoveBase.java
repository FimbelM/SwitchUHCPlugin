package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonRemove;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;

public class RemoveBase extends CommonRemove<IBase> {

	public RemoveBase(IPersistence<IBase> persistence) {
		super(persistence, "to remove the base from the world");
	}

	@Override
	protected String onRemove() {
		return "Base " + get().getName() + " removed from the world";
	}
}
