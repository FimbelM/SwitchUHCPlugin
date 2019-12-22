package fr.pederobien.uhc.event;

import org.bukkit.event.player.PlayerInteractEvent;

import fr.pederobien.uhc.managers.EColor;

public class PlayerInteractEventResponse extends EventResponse<PlayerInteractEvent> {
	private boolean restricted;
	private EColor colorAllowed;

	public PlayerInteractEventResponse(PlayerInteractEvent event, boolean restricted, EColor colorAllowed) {
		super(event);
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
