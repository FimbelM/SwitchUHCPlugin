package fr.martinfimbel.switchuhc.dictionary.dictionaries;

import fr.martinfimbel.switchuhc.dictionary.IPlayerMessage;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

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
