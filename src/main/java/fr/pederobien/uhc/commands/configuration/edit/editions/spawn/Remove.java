package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class Remove extends AbstractSpawnEdition {

	public Remove(IPersistence<ISpawn> persistence) {
		super(persistence, "remove", "to remove the spawn from the world");
	}

	@Override
	public String edit(String[] args) {
		getSpawn().remove();
		return "Spawn " + getSpawn().getName() + " removed from the world";
	}
}
