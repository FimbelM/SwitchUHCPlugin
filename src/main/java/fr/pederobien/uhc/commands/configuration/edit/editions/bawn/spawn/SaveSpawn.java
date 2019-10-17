package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.ISpawn;

public class SaveSpawn extends CommonSave<ISpawn> {

	public SaveSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, "to save a spawn");
	}

	@Override
	protected String onSave() {
		return "Spawn " + get().getName() + " saved";
	}
}
