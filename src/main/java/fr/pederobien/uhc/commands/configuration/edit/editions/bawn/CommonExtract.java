package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBawn;

public class CommonExtract<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonExtract(IPersistence<T> persistence) {
		super(persistence, "extract", "to extract world's block");
	}

	@Override
	public String edit(String[] args) {
		get().extract();
		return get().getName() + " extracted";
	}
}
