package fr.pederobien.uhc.commands.configuration.edit;

import java.util.ArrayList;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.interfaces.IWithChildEdition;

public abstract class AbstractEditConfiguration<T extends IUnmodifiableName> extends AbstractMapEdition<T>
		implements IEditConfiguration<T> {
	private IPersistence<T> persistence;
	private List<IMapEdition<T>> unmodifiableEditions;

	public AbstractEditConfiguration(IPersistence<T> persistence, String label, String explanation) {
		super(label, explanation);
		this.persistence = persistence;
		unmodifiableEditions = new ArrayList<IMapEdition<T>>();
	}

	@Override
	public IWithChildEdition<T> addEdition(IMapEdition<T> edition) {
		return !unmodifiableEditions.contains(edition) ? super.addEdition(edition.setAvailable(false))
				: super.addEdition(edition);
	}

	@Override
	public IPersistence<T> getPersistence() {
		return persistence;
	}

	@Override
	public T get() {
		return persistence.get();
	}

	@Override
	public void onCurrentChange(T newElt) {
		if (newElt != null)
			return;
		setAllAvailable(false);
	}

	@Override
	public IEditConfiguration<T> addUnmodifiableEdition(IMapEdition<T> edition) {
		unmodifiableEditions.add(edition);
		return this;
	}

	private void setAllAvailable(boolean available) {
		for (IMapEdition<T> edition : getEditions().values())
			if (!unmodifiableEditions.contains(edition))
				edition.setAvailable(available);
	}
}
