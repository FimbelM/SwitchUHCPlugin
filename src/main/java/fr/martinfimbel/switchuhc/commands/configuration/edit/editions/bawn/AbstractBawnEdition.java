package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IBawn;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public abstract class AbstractBawnEdition<T extends IBawn> extends AbstractMapEdition<T> {

	public AbstractBawnEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}
}
