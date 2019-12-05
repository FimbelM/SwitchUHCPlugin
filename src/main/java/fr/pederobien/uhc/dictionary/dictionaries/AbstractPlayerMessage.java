package fr.pederobien.uhc.dictionary.dictionaries;

import fr.pederobien.uhc.dictionary.IPlayerMessage;

public abstract class AbstractPlayerMessage implements IPlayerMessage {
	private MessageCode code;

	protected AbstractPlayerMessage(MessageCode code) {
		this.code = code;
	}

	@Override
	public MessageCode getCode() {
		return code;
	}
}
