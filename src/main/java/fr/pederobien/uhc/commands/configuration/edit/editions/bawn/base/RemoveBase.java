package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonRemove;
import fr.pederobien.uhc.interfaces.IBase;

public class RemoveBase extends CommonRemove<IBase> {

	public RemoveBase() {
		super("to remove the base from the world");
	}

	@Override
	protected String onRemove() {
		return "Base " + get().getName() + " removed from the world";
	}
}
