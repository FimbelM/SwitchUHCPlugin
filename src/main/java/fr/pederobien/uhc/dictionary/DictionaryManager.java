package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.DictionaryFactory;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.event.MessageCodeEvent;
import fr.pederobien.uhc.interfaces.IMessageCode;

public class DictionaryManager {
	private static IDictionaryContext context;

	static {
		context = new DictionaryContext();
		registerDictionary(DictionaryFactory.createEnglishDictionary()).registerDictionary(DictionaryFactory.createFrenchDictionary());
	}

	public static IDictionaryContext registerDictionary(IDictionary dictionary) {
		context.registerDictionary(dictionary);
		return context;
	}

	public static String getMessage(Player player, MessageCodeEvent event) {
		return context.getMessage(getLocale(player), event);
	}

	public static String getMessage(Player player, IMessageCode code, String... args) {
		return getMessage(player, EventFactory.createMessageCodeEvent(code, args));
	}

	public static Locale getLocale(Player player) {
		return Locale.forLanguageTag(player.getLocale().replace('_', '-'));
	}
}
