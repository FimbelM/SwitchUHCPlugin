package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class AbstractBawnEdition<T extends IBawn> extends AbstractEdition<T> {

	public AbstractBawnEdition(IPersistence<T> persistence, String label, String explanation) {
		super(persistence, label, explanation);
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		return null;
	}

	protected String showBlock(Block block) {
		return block.getX() + " " + block.getY() + " " + block.getZ();
	}
}
