package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IMessageCode;

public abstract class AbstractBawnEdition<T extends IBawn> extends AbstractMapEdition<T> {

	public AbstractBawnEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}
}
