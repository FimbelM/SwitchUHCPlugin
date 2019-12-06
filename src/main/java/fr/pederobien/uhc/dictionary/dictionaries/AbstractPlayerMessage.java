package fr.pederobien.uhc.dictionary.dictionaries;

import fr.pederobien.uhc.dictionary.IPlayerMessage;
import fr.pederobien.uhc.interfaces.IMessageCode;

public abstract class AbstractPlayerMessage implements IPlayerMessage {
	private IMessageCode code;

	protected AbstractPlayerMessage(IMessageCode code) {
		this.code = code;
	}

	@Override
	public IMessageCode getCode() {
		return code;
	}
}
