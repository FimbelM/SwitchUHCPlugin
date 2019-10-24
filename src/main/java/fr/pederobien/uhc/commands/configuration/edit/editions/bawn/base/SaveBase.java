package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.interfaces.IBase;

public class SaveBase extends CommonSave<IBase> {

	public SaveBase() {
		super("to save a base");
	}

	@Override
	protected String onSave() {
		return "Base " + get().getName() + " saved";
	}
}
