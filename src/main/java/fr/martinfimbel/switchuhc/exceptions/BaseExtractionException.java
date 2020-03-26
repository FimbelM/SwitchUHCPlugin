package fr.martinfimbel.switchuhc.exceptions;

import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public class BaseExtractionException extends UHCPluginException {
	private static final long serialVersionUID = 1L;

	public BaseExtractionException(IMessageCode code) {
		super(code);
	}
}
