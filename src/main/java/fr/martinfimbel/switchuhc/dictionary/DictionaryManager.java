package fr.martinfimbel.switchuhc.dictionary;

import java.util.Locale;

import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.DictionaryFactory;
import fr.martinfimbel.switchuhc.event.EventFactory;
import fr.martinfimbel.switchuhc.event.MessageCodeEvent;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

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
