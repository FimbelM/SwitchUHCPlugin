package fr.martinfimbel.switchuhc.observers;

import fr.martinfimbel.switchuhc.event.MessageCodeEvent;

public interface IObsMessageCodeSender {

	void sendMessage(MessageCodeEvent event);

}
