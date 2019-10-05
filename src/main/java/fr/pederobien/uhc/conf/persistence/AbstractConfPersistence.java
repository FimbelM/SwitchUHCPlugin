package fr.pederobien.uhc.conf.persistence;

import fr.pederobien.uhc.conf.IName;

public abstract class AbstractConfPersistence<T extends IName> extends AbstractPersistence<T> {
	protected static final String GAME = ROOT + "Games/";
	protected T configuration;

	public AbstractConfPersistence(T configuration) {
		this.configuration = configuration;
	}
}
