package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.commands.configuration.edit.IEditConfig;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.persistence.IPersistence;

public abstract class AbstractEditionsFactory<T extends IUnmodifiableName> {
	protected IPersistence<T> persistence;
	
	public AbstractEditionsFactory(IPersistence<T> persistence) {
		this.persistence = persistence;
	}
	
	public IEdition createHelpEdition(IEditConfig conf) {
		return new CommonHelp(conf);
	}
	
	public abstract IEdition createListEdition();
	
	public abstract IEdition createCurrentEdition();
	
	public abstract IEdition createNewEdition();
	
	public abstract IEdition createRenameEdition();
	
	public abstract IEdition createSaveEdition();
}
