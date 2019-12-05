package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import fr.pederobien.uhc.dictionary.dictionaries.DictionaryFactory;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class DictionaryManager {
	private static IDictionaryContext context = new DictionaryContext();

	static {
		context.registerDictionary(DictionaryFactory.createEnglishDictionary())
				.registerDictionary(DictionaryFactory.createFrenchDictionary());
	}

	public static String getMessage(Locale locale, MessageCode code) {
		System.out.println("Locale parsed : " + locale);
		return context.getMessage(locale, code);
	}
}
