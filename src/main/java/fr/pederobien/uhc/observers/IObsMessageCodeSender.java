package fr.pederobien.uhc.observers;

import fr.pederobien.uhc.event.MessageCodeEvent;

public interface IObsMessageCodeSender {

	void sendMessage(MessageCodeEvent event);

}
