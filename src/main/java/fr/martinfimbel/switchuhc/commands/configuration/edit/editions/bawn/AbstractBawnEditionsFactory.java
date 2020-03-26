package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.martinfimbel.switchuhc.interfaces.IBawn;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;

public abstract class AbstractBawnEditionsFactory<T extends IBawn> extends AbstractEditionsFactory<T> {

	public AbstractBawnEditionsFactory(IPersistence<T> persistence) {
		super(persistence);
	}

	public IMapEdition<T> createCenterEdition() {
		return new CommonCenter<T>();
	}

	public abstract IMapEdition<T> createDimensionsEdition();

	public abstract IMapEdition<T> createExtractEdition();

	public abstract IMapEdition<T> createRenameEdition();

	public abstract IMapEdition<T> createLaunchEdition();

	public abstract IMapEdition<T> createRemoveEdition();
}
