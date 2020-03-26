package fr.martinfimbel.switchuhc.dictionary;

import java.util.Locale;

import fr.martinfimbel.switchuhc.event.MessageCodeEvent;

public interface IDictionaryContext {

	IDictionaryContext registerDictionary(IDictionary dictionary);

	String getMessage(Locale locale, MessageCodeEvent event);

	IDictionaryContext removeDictionary(IDictionary dictionary);

}
