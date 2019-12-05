package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class SaveBase extends CommonSave<IBase> {

	public SaveBase() {
		super(MessageCode.SAVE_BASE_EXPLANATION);
	}

	@Override
	protected MessageCode onSave() {
		return MessageCode.SAVE_BASE_SAVED;
	}
}
