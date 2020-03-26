package fr.martinfimbel.switchuhc.dictionary;

import java.util.List;
import java.util.Locale;

import fr.martinfimbel.switchuhc.event.MessageCodeEvent;

public interface IDictionary {

	List<Locale> getLocale();

	String getMessage(MessageCodeEvent event);

	IDictionary registerMessage(IPlayerMessage message);
}
