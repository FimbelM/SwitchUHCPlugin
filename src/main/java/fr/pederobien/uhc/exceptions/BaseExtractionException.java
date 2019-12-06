package fr.pederobien.uhc.exceptions;

import fr.pederobien.uhc.interfaces.IMessageCode;

public class BaseExtractionException extends UHCPluginException {
	private static final long serialVersionUID = 1L;
	private IMessageCode code;

	public BaseExtractionException(IMessageCode code) {
		this.code = code;
	}

	public IMessageCode getCode() {
		return code;
	}
}
