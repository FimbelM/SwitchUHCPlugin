package fr.pederobien.uhc.persistence;

import fr.pederobien.uhc.interfaces.IName;

public abstract class AbstractConfPersistence<T extends IName> extends AbstractPersistence<T> {
	protected static final String GAME = ROOT + "Games/";

	public AbstractConfPersistence(T elt) {
		super(elt);
		checkAndWriteDefault();
	}
	
	private void checkAndWriteDefault() {
		checkParentFolderExistence();
		if (checkSaveExistence())
			save();
	}
}
