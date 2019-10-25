package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.interfaces.IWithChildEdition;

public abstract class AbstractEditConfiguration<T extends IUnmodifiableName> extends AbstractMapEdition<T>
		implements IEditConfiguration<T> {
	private IPersistence<T> persistence;

	public AbstractEditConfiguration(IPersistence<T> persistence, String label, String explanation) {
		super(label, explanation);
		this.persistence = persistence;
	}
	
	@Override
	public IWithChildEdition<T> addEdition(IMapEdition<T> edition) {
		return super.addEdition(edition.setAvailable(false));
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

	private void setAllAvailable(boolean available) {
		for (IMapEdition<T> edition : getEditions().values())
			edition.setAvailable(available);
	}
}
