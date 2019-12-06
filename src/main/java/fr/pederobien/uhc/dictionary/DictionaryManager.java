package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import fr.pederobien.uhc.dictionary.dictionaries.DictionaryFactory;
import fr.pederobien.uhc.event.MessageCodeEvent;

public class DictionaryManager {
	private static IDictionaryContext context = new DictionaryContext();

	static {
		context.registerDictionary(DictionaryFactory.createEnglishDictionary())
				.registerDictionary(DictionaryFactory.createFrenchDictionary());
	}

	public static String getMessage(Locale locale, MessageCodeEvent event) {
		return context.getMessage(locale, event);
	}
}
