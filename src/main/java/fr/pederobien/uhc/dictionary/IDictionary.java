package fr.pederobien.uhc.dictionary;

import java.util.List;
import java.util.Locale;

import fr.pederobien.uhc.event.MessageCodeEvent;

public interface IDictionary {

	List<Locale> getLocale();

	String getMessage(MessageCodeEvent event);

	IDictionary registerMessage(IPlayerMessage message);
}
