package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonRemove;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class RemoveSpawn extends CommonRemove<ISpawn> {

	public RemoveSpawn() {
		super(MessageCode.REMOVE_SPAWN_EXPLANATION);
	}

	@Override
	protected MessageCode onRemove() {
		return MessageCode.REMOVE_SPAWN_REMOVED.withArgs(get().getName());
	}
}
