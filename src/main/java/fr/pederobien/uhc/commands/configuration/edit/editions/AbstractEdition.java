package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractEdition<T extends IUnmodifiableName> extends AbstractMapEdition {
	private IPersistence<T> persistence;

	public AbstractEdition(IPersistence<T> persistence, String label, String explanation) {
		super(label, explanation);
		this.persistence = persistence;
		if (persistence != null)
			this.persistence.addObserver(this);
	}

	protected IPersistence<T> getPersistence() {
		return persistence;
	}

	protected T get() {
		return persistence.get();
	}
}
