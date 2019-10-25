package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.interfaces.IBase;

public class DeleteBase extends CommonDelete<IBase> {

	public DeleteBase() {
		super("to delete a base");
	}

	@Override
	protected String onDeleted(String name) {
		return "Base " + name + " deleted";
	}
}
