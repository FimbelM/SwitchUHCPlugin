package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.CommonDimensions;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class DimensionsBase extends CommonDimensions<IBase> {

	public DimensionsBase() {
		super(MessageCode.DIMENSIONS_BASE_EXPLANATION);
	}

	@Override
	protected void dimensionsDefined(int width, int height, int depth) {
		sendMessage(MessageCode.DIMENSIONS_BASE_DEFINED, get().getName(), "" + width, "" + height, "" + depth);
	}
}
