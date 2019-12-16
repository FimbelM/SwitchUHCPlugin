package fr.pederobien.uhc.event;

import fr.pederobien.uhc.managers.EColor;

public class PlayerInteractEventResponse {
	private boolean restricted;
	private EColor colorAllowed;

	public PlayerInteractEventResponse(boolean restricted, EColor colorAllowed) {
		this.restricted = restricted;
		this.colorAllowed = colorAllowed;
	}

	public EColor getColorAllowed() {
		return colorAllowed;
	}

	public boolean isRestricted() {
		return restricted;
	}
}
