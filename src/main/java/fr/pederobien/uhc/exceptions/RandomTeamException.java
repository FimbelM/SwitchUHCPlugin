package fr.pederobien.uhc.exceptions;

import fr.pederobien.uhc.interfaces.IMessageCode;

public class RandomTeamException extends UHCPluginException {
	private static final long serialVersionUID = 1L;

	public RandomTeamException(IMessageCode code) {
		super(code);
	}
}
