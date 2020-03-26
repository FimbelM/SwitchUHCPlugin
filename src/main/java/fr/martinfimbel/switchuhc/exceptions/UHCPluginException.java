package fr.martinfimbel.switchuhc.exceptions;

import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public class UHCPluginException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private IMessageCode code;

	public UHCPluginException(IMessageCode code) {
		this.code = code;
	}

	public IMessageCode getCode() {
		return code;
	}
}
