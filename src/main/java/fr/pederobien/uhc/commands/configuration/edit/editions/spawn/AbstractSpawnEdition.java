package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import org.bukkit.block.Block;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public abstract class AbstractSpawnEdition implements IEdition {
	private SpawnEditions edition;
	private SpawnPersistence persistence;

	public AbstractSpawnEdition(SpawnPersistence persistence, SpawnEditions edition) {
		this.persistence = persistence;
		this.edition = edition;
	}

	@Override
	public String getLabel() {
		return edition.getLabel();
	}

	@Override
	public String help() {
		return edition.help();
	}

	protected SpawnPersistence getPersistence() {
		return persistence;
	}

	protected Spawn getSpawn() {
		return persistence.get();
	}

	protected String showBlock(Block block) {
		return block.getX() + " " + block.getY() + " " + block.getZ();
	}
}
