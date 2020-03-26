package fr.martinfimbel.switchuhc.commands.configuration.edit.editions;

import fr.martinfimbel.switchuhc.interfaces.IMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;

public abstract class AbstractEditionsFactory<T extends IUnmodifiableName> {
	protected IPersistence<T> persistence;

	protected AbstractEditionsFactory(IPersistence<T> persistence) {
		this.persistence = persistence;
	}

	public abstract IMapEdition<T> createListEdition();

	public abstract IMapEdition<T> createCurrentEdition();

	public abstract IMapEdition<T> createNewEdition();

	public abstract IMapEdition<T> createRenameEdition();

	public abstract IMapEdition<T> createSaveEdition();

	public abstract IMapEdition<T> createDeleteEdition();

	public abstract IMapEdition<T> createResetEdition();

	public IPersistence<T> getPersistence() {
		return persistence;
	}
}
