package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class CurrentSpawn extends AbstractBawnEdition<ISpawn> {

	public CurrentSpawn() {
		super("current", MessageCode.CURRENT_SPAWN_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		sendMessage(MessageCode.CURRENT_SPAWN_MESSAGE, get().toString());
	}
}
