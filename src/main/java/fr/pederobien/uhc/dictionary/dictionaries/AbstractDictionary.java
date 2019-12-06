package fr.pederobien.uhc.dictionary.dictionaries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import fr.pederobien.uhc.dictionary.IDictionary;
import fr.pederobien.uhc.dictionary.IPlayerMessage;
import fr.pederobien.uhc.event.MessageCodeEvent;
import fr.pederobien.uhc.interfaces.IMessageCode;

public abstract class AbstractDictionary implements IDictionary {
	private List<Locale> locales;
	private HashMap<IMessageCode, IPlayerMessage> map;

	protected AbstractDictionary(Locale... locale) {
		this.locales = Arrays.asList(locale);
		map = new HashMap<IMessageCode, IPlayerMessage>();
	}

	@Override
	public List<Locale> getLocale() {
		return locales;
	}

	@Override
	public String getMessage(MessageCodeEvent event) {
		return map.get(event.getCode()).getMessage(event.getArgs());
	}

	@Override
	public IDictionary registerMessage(IPlayerMessage message) {
		map.put(message.getCode(), message);
		return this;
	}

	@Override
	public String toString() {
		String localestr = "";
		for (int i = 0; i < locales.size(); i++) {
			localestr += locales.get(i).toString();
			if (i < locales.size() - 1)
				localestr += ", ";
		}
		return "{dictionary, languages={" + localestr + "}}";
	}
}
