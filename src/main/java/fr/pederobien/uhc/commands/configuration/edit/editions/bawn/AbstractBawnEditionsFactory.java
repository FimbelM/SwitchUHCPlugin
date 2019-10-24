package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class AbstractBawnEditionsFactory<T extends IBawn> extends AbstractEditionsFactory<T> {

	public AbstractBawnEditionsFactory(IPersistence<T> persistence) {
		super(persistence);
	}

	public IMapEdition<T> createCenterEdition() {
		return new CommonCenter<T>();
	}

	public IMapEdition<T> createDimensionsEdition() {
		return new CommonDimensions<T>();
	}

	public abstract IMapEdition<T> createExtractEdition();

	public abstract IMapEdition<T> createRenameEdition();

	public abstract IMapEdition<T> createLaunchEdition();

	public abstract IMapEdition<T> createRemoveEdition();
}
