package fr.pederobien.uhc.conf.persistence;

import java.io.File;

public abstract class AbstractConfPersistence<T> extends AbstractPersistence<T> implements IConfPersistence<T> {
	protected static final String GAME = ROOT + "Games/";
	protected T configuration;

	public AbstractConfPersistence(T configuration) {
		this.configuration = configuration;
	}

	@Override
	public T getConfiguration() {
		return configuration;
	}
	
	@Override
	public void save() {
		save(configuration);
	}
	
	protected void checkAndWriteDefaultConf(String path, T configuration) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
			save(configuration);
		}
	}
	
	protected boolean exist(String path) {
		return new File(path).exists();
	}
	
	protected boolean mkdirs(String path) {
		return new File(path).mkdirs();
	}
}
