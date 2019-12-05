package fr.pederobien.uhc.dictionary;

import java.util.HashMap;
import java.util.Locale;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class DictionaryContext implements IDictionaryContext {
	private HashMap<Locale, IDictionary> map;

	protected DictionaryContext() {
		map = new HashMap<Locale, IDictionary>();
	}

	@Override
	public IDictionaryContext registerDictionary(IDictionary dictionary) {
		for (Locale locale : dictionary.getLocale())
			map.put(locale, dictionary);
		return this;
	}

	@Override
	public String getMessage(Locale locale, MessageCode code) {
		return map.get(locale) == null || map.get(locale).getMessage(code) == null
				? map.get(Locale.ENGLISH).getMessage(code)
				: map.get(locale).getMessage(code);
	}

	@Override
	public IDictionaryContext removeDictionary(IDictionary dictionary) {
		for (Locale locale : dictionary.getLocale())
			map.remove(locale);
		return this;
	}
}
