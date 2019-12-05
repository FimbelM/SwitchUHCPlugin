package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonDimensions;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class DimensionsSpawn extends CommonDimensions<ISpawn> {

	public DimensionsSpawn() {
		super(MessageCode.DIMENSIONS_SPAWN_EXPLANATION);
	}

	@Override
	protected MessageCode dimensionsDefined(int width, int height, int depth) {
		return MessageCode.DIMENSIONS_SPAWN_DEFINED.withArgs("" + width, "" + height, "" + depth);
	}
}
