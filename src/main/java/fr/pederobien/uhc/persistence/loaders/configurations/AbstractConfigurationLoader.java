package fr.pederobien.uhc.persistence.loaders.configurations;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.persistence.loaders.AbstractPersistenceLoader;

public abstract class AbstractConfigurationLoader<T extends IConfiguration> extends AbstractPersistenceLoader<T> {

	public AbstractConfigurationLoader(String version, T elt) {
		super(version, elt);
	}
}
