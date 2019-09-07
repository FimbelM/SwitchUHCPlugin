package fr.pederobien.uhc.conf.persistence;

public abstract class AbstractConfPersistence<T> extends AbstractPersistence<T> {
	protected static final String GAME = ROOT + "Games/";
	protected T configuration;

	public AbstractConfPersistence(T configuration) {
		this.configuration = configuration;
	}
}
