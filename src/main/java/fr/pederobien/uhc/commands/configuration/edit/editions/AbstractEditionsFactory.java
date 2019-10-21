package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractEditionsFactory<T extends IUnmodifiableName> {
	protected IPersistence<T> persistence;

	protected AbstractEditionsFactory(IPersistence<T> persistence) {
		this.persistence = persistence;
	}

	public IMapEdition createHelpEdition(IMapEdition conf) {
		return new CommonHelp(conf);
	}

	public abstract IMapEdition createListEdition();

	public abstract IMapEdition createCurrentEdition();

	public abstract IMapEdition createNewEdition();

	public abstract IMapEdition createRenameEdition();

	public abstract IMapEdition createSaveEdition();
	
	public IPersistence<T> getPersistence() {
		return persistence;
	}
}
