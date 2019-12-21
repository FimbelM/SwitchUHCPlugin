package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class CurrentSpawn extends AbstractBawnEdition<ISpawn> {

	public CurrentSpawn() {
		super("current", MessageCode.CURRENT_SPAWN_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		sendMessage(MessageCode.CURRENT_SPAWN_MESSAGE, get().toString());
	}
}
