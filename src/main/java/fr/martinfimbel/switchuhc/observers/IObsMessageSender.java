package fr.martinfimbel.switchuhc.observers;

import fr.martinfimbel.switchuhc.event.MessageEvent;

public interface IObsMessageSender {

	void sendMessage(MessageEvent event);
}
