package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public abstract class AbstractSpawnEdition extends AbstractEdition<ISpawn> implements IEdition {

	public AbstractSpawnEdition(IPersistence<ISpawn> persistence, String label, String explanation) {
		super(persistence, label, explanation);
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		return null;
	}

	protected ISpawn getSpawn() {
		return getConf();
	}

	protected String showBlock(Block block) {
		return block.getX() + " " + block.getY() + " " + block.getZ();
	}
}
