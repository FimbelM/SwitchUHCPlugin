package fr.pederobien.uhc.dictionary;

import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.DictionaryFactory;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.event.MessageCodeEvent;
import fr.pederobien.uhc.interfaces.IMessageCode;

public class DictionaryManager {
	private static IDictionaryContext context = new DictionaryContext();

	static {
		context.registerDictionary(DictionaryFactory.createEnglishDictionary()).registerDictionary(DictionaryFactory.createFrenchDictionary());
	}

	public static String getMessage(Player player, MessageCodeEvent event) {
		return context.getMessage(NotificationCenter.getLocale(player), event);
	}

	public static String getMessage(Player player, IMessageCode code, String... args) {
		return context.getMessage(NotificationCenter.getLocale(player), EventFactory.createMessageCodeEvent(code, args));
	}
}
