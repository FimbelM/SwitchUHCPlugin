package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonReset;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class ResetSpawn extends CommonReset<ISpawn> {

	public ResetSpawn() {
		super(MessageCode.RESET_SPAWN_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_SPAWN_MESSAGE, name);
	}
}
