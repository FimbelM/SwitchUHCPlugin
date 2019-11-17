package fr.pederobien.uhc.persistence;

import java.io.FileNotFoundException;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class AbstractConfPersistence<T extends IConfiguration> extends AbstractPersistence<T> {
	protected static final String GAME = ROOT + "Games/";

	public AbstractConfPersistence(IDefaultContent defaultContent) {
		super(defaultContent);
	}
	
	@Override
	public IPersistence<T> load(String name) throws FileNotFoundException {
		get().getTeams().clear();
		return super.load(name);
	}
}
