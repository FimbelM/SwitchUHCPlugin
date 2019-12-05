package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;

public abstract class AbstractConfEdition<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractConfEdition(String label, MessageCode explanation) {
		super(label, explanation);
	}
}
