package fr.martinfimbel.switchuhc.persistence.loaders.configurations;

import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.persistence.loaders.AbstractPersistenceLoader;

public abstract class AbstractConfigurationLoader<T extends IConfiguration> extends AbstractPersistenceLoader<T> {

	public AbstractConfigurationLoader(String version, T elt) {
		super(version, elt);
	}
}
