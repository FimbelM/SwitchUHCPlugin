package fr.pederobien.uhc.exceptions;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class BaseExtractionException extends UHCPluginException {
	private static final long serialVersionUID = 1L;
	private MessageCode code;

	public BaseExtractionException(MessageCode code) {
		this.code = code;
	}

	public MessageCode getCode() {
		return code;
	}
}
