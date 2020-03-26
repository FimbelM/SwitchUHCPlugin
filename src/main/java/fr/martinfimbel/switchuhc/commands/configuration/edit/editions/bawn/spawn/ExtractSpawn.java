package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class ExtractSpawn extends CommonExtract<ISpawn> {

	public ExtractSpawn() {
		super(MessageCode.EXTRACT_SPAWN_EXPLANATION);
	}

	@Override
	protected void onExtracted() {
		sendMessage(MessageCode.EXTRACT_SPAWN_EXTRACTED, get().getName());
	}
}
