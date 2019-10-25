package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractEditionsFactory<T extends IUnmodifiableName> {
	protected IPersistence<T> persistence;

	protected AbstractEditionsFactory(IPersistence<T> persistence) {
		this.persistence = persistence;
	}

	public IMapEdition<T> createHelpEdition(IEditConfiguration<T> conf) {
		return new CommonHelp<T>(conf);
	}

	public abstract IMapEdition<T> createListEdition();

	public abstract IMapEdition<T> createCurrentEdition();

	public abstract IMapEdition<T> createNewEdition();

	public abstract IMapEdition<T> createRenameEdition();

	public abstract IMapEdition<T> createSaveEdition();
	
	public abstract IMapEdition<T> createDeleteEdition();
	
	public IPersistence<T> getPersistence() {
		return persistence;
	}
}
