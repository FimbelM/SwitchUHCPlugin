package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.MessageEvent;
import fr.pederobien.uhc.managers.PlayerManager;

public class NotificationCenter {

	public static void sendMessage(MessageEvent event) {
		switch (event.getCode().getPermission()) {
		case ALL:
			PlayerManager.getPlayers().forEach(p -> sendMessage(p, event.getCode()));
			break;
		case COMMAND_SENDER:
			sendMessage((Player) event.getSender(), event.getCode());
			break;
		case OPERATORS:
			BukkitManager.getOnlineOperators().forEach(p -> sendMessage(p, event.getCode()));
		default:
			break;
		}
	}

	public static Locale getLocale(Player player) {
		System.out.println("Locale : " + player.getLocale());
		return Locale.forLanguageTag(player.getLocale().replace('_', '-'));
	}

	private static void sendMessage(Player player, MessageCode code) {
		PlayerManager.sendMessageToPlayer(player, DictionaryManager.getMessage(getLocale(player), code));
	}
}
