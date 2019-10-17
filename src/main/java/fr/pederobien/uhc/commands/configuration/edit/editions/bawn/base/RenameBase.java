package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBase;

public class RenameBase extends CommonRename<IBase> {

	public RenameBase(IPersistence<IBase> persistence) {
		super(persistence, "to rename the base");
	}

	@Override
	protected String onAlreadyExisting(String newName) {
		return "Cannot rename base " + get().getName() + " as " + newName + ", base already exist";
	}

	@Override
	protected String onRename(String oldName, String newName) {
		return "Base " + oldName + " renamed as " + newName;
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot rename the base, need the name";
	}
}
