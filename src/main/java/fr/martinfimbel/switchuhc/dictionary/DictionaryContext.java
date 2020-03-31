package fr.martinfimbel.switchuhc.dictionary;

import java.util.HashMap;
import java.util.Locale;

import fr.martinfimbel.switchuhc.event.MessageCodeEvent;

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
	public String getMessage(Locale locale, MessageCodeEvent event) {
		try {
			return map.get(locale).getMessage(event);
		} catch(NullPointerException | IndexOutOfBoundsException e) {
			return map.get(Locale.ENGLISH).getMessage(event);
		}
	}

	@Override
	public IDictionaryContext removeDictionary(IDictionary dictionary) {
		for (Locale locale : dictionary.getLocale())
			map.remove(locale);
		return this;
	}
}
