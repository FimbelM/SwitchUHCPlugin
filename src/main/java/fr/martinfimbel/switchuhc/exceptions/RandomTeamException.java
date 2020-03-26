package fr.martinfimbel.switchuhc.exceptions;

import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public class RandomTeamException extends UHCPluginException {
	private static final long serialVersionUID = 1L;

	public RandomTeamException(IMessageCode code) {
		super(code);
	}
}
