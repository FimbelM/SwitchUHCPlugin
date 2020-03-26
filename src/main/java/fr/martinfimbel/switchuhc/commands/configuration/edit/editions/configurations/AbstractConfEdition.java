package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public abstract class AbstractConfEdition<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractConfEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}
}
