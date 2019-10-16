package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBawn;

public abstract class AbstractBawnEditionsFactory<T extends IBawn> extends AbstractEditionsFactory<T> {

	public AbstractBawnEditionsFactory(IPersistence<T> persistence) {
		super(persistence);
	}

	public IEdition createCenterEdition() {
		return new CommonCenter<T>(persistence);
	}

	public IEdition createDimensionsEdition() {
		return new CommonDimensions<T>(persistence);
	}

	public IEdition createExtractEdition() {
		return new CommonExtract<T>(persistence);
	}

	public abstract IEdition createRenameEdition();
}
