package fr.pederobien.uhc.event;

import org.bukkit.event.Event;

public class BaseEventResponse<T extends Event> extends EventResponse<T> {
	private boolean founded;

	protected BaseEventResponse(T event, boolean founded) {
		super(event);
		this.founded = founded;
	}

	public boolean isFounded() {
		return founded;
	}
}
