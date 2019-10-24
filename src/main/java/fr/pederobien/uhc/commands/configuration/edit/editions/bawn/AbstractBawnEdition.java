package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import org.bukkit.block.Block;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IBawn;

public abstract class AbstractBawnEdition<T extends IBawn> extends AbstractMapEdition<T> {

	public AbstractBawnEdition(String label, String explanation) {
		super(label, explanation);
	}

	protected String showBlock(Block block) {
		return block.getX() + " " + block.getY() + " " + block.getZ();
	}
}
