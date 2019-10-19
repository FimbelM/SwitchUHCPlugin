package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class AbstractBawnEditionsFactory<T extends IBawn> extends AbstractEditionsFactory<T> {

	public AbstractBawnEditionsFactory(IPersistence<T> persistence) {
		super(persistence);
	}

	public IMapEdition createCenterEdition() {
		return new CommonCenter<T>(persistence);
	}

	public IMapEdition createDimensionsEdition() {
		return new CommonDimensions<T>(persistence);
	}

	public abstract IMapEdition createExtractEdition();

	public abstract IMapEdition createRenameEdition();
}
