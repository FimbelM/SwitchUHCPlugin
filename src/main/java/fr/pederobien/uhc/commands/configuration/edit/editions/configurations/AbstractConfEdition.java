package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMessageCode;

public abstract class AbstractConfEdition<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractConfEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}
}
