package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBawn;

public abstract class AbstractBawnEdition<T extends IBawn> extends AbstractMapEdition<T> {

	public AbstractBawnEdition(String label, MessageCode explanation) {
		super(label, explanation);
	}
}
