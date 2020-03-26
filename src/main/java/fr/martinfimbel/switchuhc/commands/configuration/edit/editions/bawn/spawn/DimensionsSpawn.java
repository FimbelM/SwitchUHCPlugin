package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.CommonDimensions;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class DimensionsSpawn extends CommonDimensions<ISpawn> {

	public DimensionsSpawn() {
		super(MessageCode.DIMENSIONS_SPAWN_EXPLANATION);
	}

	@Override
	protected void dimensionsDefined(int width, int height, int depth) {
		sendMessage(MessageCode.DIMENSIONS_SPAWN_DEFINED, get().getName(), "" + width, "" + height, "" + depth);
	}
}
