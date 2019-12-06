package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import fr.pederobien.uhc.event.MessageCodeEvent;

public interface IDictionaryContext {

	IDictionaryContext registerDictionary(IDictionary dictionary);

	String getMessage(Locale locale, MessageCodeEvent event);

	IDictionaryContext removeDictionary(IDictionary dictionary);

}
