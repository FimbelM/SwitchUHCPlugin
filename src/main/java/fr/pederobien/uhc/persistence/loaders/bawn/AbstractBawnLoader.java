package fr.pederobien.uhc.persistence.loaders.bawn;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.persistence.loaders.AbstractPersistenceLoader;

public abstract class AbstractBawnLoader<T extends IBawn> extends AbstractPersistenceLoader<T> {

	public AbstractBawnLoader(String version, T elt) {
		super(version, elt);
	}
}
