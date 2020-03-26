package fr.martinfimbel.switchuhc.persistence;

import fr.martinfimbel.switchuhc.interfaces.IBawn;

public abstract class AbstractBawnPersistence<T extends IBawn> extends AbstractPersistence<T> {

	protected AbstractBawnPersistence(IDefaultContent defaultContent) {
		super(defaultContent);
	}
}
