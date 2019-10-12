package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.commands.configuration.edit.IEditConfig;
import fr.pederobien.uhc.conf.IUnmodifiableName;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public abstract class AbstractEditionsFactory<T extends IUnmodifiableName> {
	protected IPersistence<T> persistence;
	
	public AbstractEditionsFactory(IPersistence<T> persistence) {
		this.persistence = persistence;
	}
	
	public IEdition createHelpEdition(IEditConfig conf) {
		return new CommonHelp(conf);
	}
}
