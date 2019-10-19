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

	public abstract IEdition createListEdition();

	public abstract IEdition createCurrentEdition();

	public abstract IEdition createNewEdition();

	public abstract IEdition createRenameEdition();

	public abstract IEdition createSaveEdition();
}
