package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import java.util.Collection;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.exceptions.BaseExtractionException;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.managers.ETeam;

public class ExtractBase extends CommonExtract<IBase> {

	public ExtractBase() {
		super(MessageCode.EXTRACT_BASE_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		try {
			return super.edit(args);
		} catch (BaseExtractionException e) {
			return e.getCode();
		}
	}

	@Override
	protected MessageCode onExtracted() {
		switch (get().getChestsNumber()) {
		case 1:
			return MessageCode.EXTRACT_BASE_ONE_CHEST_EXTRACTED.withArgs(get().getName(),
					get().getChests().values().iterator().next().getColorNameWithColor());
		default:
			return MessageCode.EXTRACT_BASE_CHESTS_EXTRACTED.withArgs(get().getName(),
					colorName(get().getChests().values()));
		}
	}

	private String colorName(Collection<ETeam> teams) {
		String colorName = "";
		for (ETeam team : teams)
			colorName += team.getColorNameWithColor() + " ";
		return colorName;
	}
}
