package fr.martinfimbel.switchuhc.persistence.loaders;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;

public abstract class AbstractPersistenceLoader<T extends IUnmodifiableName> implements IPersistenceLoader<T> {
	private T elt;
	private String version;

	public AbstractPersistenceLoader(String version, T elt) {
		this.version = version;
		this.elt = elt;
	}

	@Override
	public T get() {
		return elt;
	}

	@Override
	public String getVersion() {
		return version;
	}
}
