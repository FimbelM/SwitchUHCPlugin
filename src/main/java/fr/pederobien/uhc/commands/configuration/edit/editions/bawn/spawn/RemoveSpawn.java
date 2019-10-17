package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonRemove;
import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class RemoveSpawn extends CommonRemove<ISpawn> {

	public RemoveSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, "to remove the spawn from the world");
	}

	@Override
	protected String onRemove() {
		return "Spawn " + get().getName() + " removed from the world";
	}
}
