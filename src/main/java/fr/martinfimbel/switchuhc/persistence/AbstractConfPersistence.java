package fr.martinfimbel.switchuhc.persistence;

import fr.martinfimbel.switchuhc.interfaces.IConfiguration;

public abstract class AbstractConfPersistence<T extends IConfiguration> extends AbstractPersistence<T> {
	protected static final String GAME = ROOT + "Games/";

	public AbstractConfPersistence(IDefaultContent defaultContent) {
		super(defaultContent);
	}
}
