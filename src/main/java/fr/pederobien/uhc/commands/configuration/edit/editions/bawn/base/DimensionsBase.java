package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonDimensions;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class DimensionsBase extends CommonDimensions<IBase> {

	public DimensionsBase() {
		super(MessageCode.DIMENSIONS_BASE_EXPLANATION);
	}

	@Override
	protected void dimensionsDefined(int width, int height, int depth) {
		sendMessage(MessageCode.DIMENSIONS_BASE_DEFINED, get().getName(), "" + width, "" + height, "" + depth);
	}
}
