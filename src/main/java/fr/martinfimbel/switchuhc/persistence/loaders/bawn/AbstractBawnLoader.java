package fr.martinfimbel.switchuhc.persistence.loaders.bawn;

import fr.martinfimbel.switchuhc.interfaces.IBawn;
import fr.martinfimbel.switchuhc.persistence.loaders.AbstractPersistenceLoader;

public abstract class AbstractBawnLoader<T extends IBawn> extends AbstractPersistenceLoader<T> {

	public AbstractBawnLoader(String version, T elt) {
		super(version, elt);
	}
}
