package fr.martinfimbel.switchuhc.event;

import org.bukkit.event.player.PlayerInteractEvent;

import fr.martinfimbel.switchuhc.managers.EColor;

public class PlayerInteractEventResponse extends BaseEventResponse<PlayerInteractEvent> {
	private boolean restricted;
	private EColor colorAllowed;

	public PlayerInteractEventResponse(PlayerInteractEvent event, boolean founded, boolean restricted, EColor colorAllowed) {
		super(event, founded);
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
