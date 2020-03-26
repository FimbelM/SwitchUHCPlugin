package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import java.util.Collection;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.exceptions.BaseExtractionException;
import fr.martinfimbel.switchuhc.interfaces.IBase;
import fr.martinfimbel.switchuhc.managers.EColor;

public class ExtractBase extends CommonExtract<IBase> {

	public ExtractBase() {
		super(MessageCode.EXTRACT_BASE_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			super.edit(args);
		} catch (BaseExtractionException e) {
			sendMessage(e.getCode());
		}
	}

	@Override
	protected void onExtracted() {
		switch (get().getChestsNumber()) {
		case 1:
			sendMessage(MessageCode.EXTRACT_BASE_ONE_CHEST_EXTRACTED, get().getName(), colorName(get().getChests().values()));
			break;
		default:
			sendMessage(MessageCode.EXTRACT_BASE_CHESTS_EXTRACTED, get().getName(), colorName(get().getChests().values()));
			break;
		}
	}

	private String colorName(Collection<EColor> colors) {
		String colorName = "";
		for (EColor color : colors)
			colorName += color.getColoredColorName() + " ";
		return colorName;
	}
}
