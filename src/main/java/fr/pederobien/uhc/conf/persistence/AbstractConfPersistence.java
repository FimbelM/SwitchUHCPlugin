package fr.pederobien.uhc.conf.persistence;

import java.io.File;

public abstract class AbstractConfPersistence<T> extends AbstractPersistence<T> {
	protected static final String GAME = ROOT + "Games/";
	protected T configuration;

	public AbstractConfPersistence(T configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public void save() {
		save(configuration);
	}
	
	protected boolean exist(String path) {
		return new File(path).exists();
	}
	
	protected boolean mkdirs(String path) {
		return new File(path).mkdirs();
	}
}
