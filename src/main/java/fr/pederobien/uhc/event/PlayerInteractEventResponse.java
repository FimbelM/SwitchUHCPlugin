package fr.pederobien.uhc.event;

import fr.pederobien.uhc.managers.ETeam;

public class PlayerInteractEventResponse {
	private boolean restricted;
	private ETeam colorAllowed;

	public PlayerInteractEventResponse(boolean restricted, ETeam colorAllowed) {
		this.restricted = restricted;
		this.colorAllowed = colorAllowed;
	}

	public ETeam getColorAllowed() {
		return colorAllowed;
	}

	public boolean isRestricted() {
		return restricted;
	}
}
