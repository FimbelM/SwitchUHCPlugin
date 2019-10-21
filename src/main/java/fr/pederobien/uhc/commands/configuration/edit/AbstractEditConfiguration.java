package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractEditConfiguration<T extends IUnmodifiableName> extends AbstractEdition<T> {

	public AbstractEditConfiguration(IPersistence<T> persistence, String label, String explanation) {
		super(persistence, label, explanation);
	}
	
	@Override
	public void addEditions(IMapEdition... editions) {
		for (IMapEdition edition : editions)
			edition.setAvailable(false);
		super.addEditions(editions);
	}
	
	protected void availableAll() {
		for (String label : getEditions().keySet())
			getEditions().get(label).setAvailable(true);
	}
}
