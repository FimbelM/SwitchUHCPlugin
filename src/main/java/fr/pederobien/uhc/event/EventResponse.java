package fr.pederobien.uhc.event;

import org.bukkit.event.Event;

public class EventResponse<T extends Event> {
	private T event;

	protected EventResponse(T event) {
		this.event = event;
	}

	T getEventSource() {
		return event;
	}
}
