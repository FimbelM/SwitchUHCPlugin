package fr.pederobien.uhc.persistence;

import fr.pederobien.uhc.interfaces.IBawn;

public abstract class AbstractBawnPersistence<T extends IBawn> extends AbstractPersistence<T> {

	protected AbstractBawnPersistence(IDefaultContent defaultContent) {
		super(defaultContent);
	}
}
