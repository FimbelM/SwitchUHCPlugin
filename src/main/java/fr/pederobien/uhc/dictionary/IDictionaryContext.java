package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public interface IDictionaryContext {

	IDictionaryContext registerDictionary(IDictionary dictionary);

	String getMessage(Locale locale, MessageCode code);

	IDictionaryContext removeDictionary(IDictionary dictionary);

}
