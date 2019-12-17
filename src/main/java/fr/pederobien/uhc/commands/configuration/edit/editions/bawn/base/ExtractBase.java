package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import java.util.Collection;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.exceptions.BaseExtractionException;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.managers.EColor;

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
