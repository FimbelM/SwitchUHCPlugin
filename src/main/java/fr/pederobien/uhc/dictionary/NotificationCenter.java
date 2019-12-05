package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.managers.PlayerManager;

public class NotificationCenter {

	public static void sendMessage(CommandSender player, MessageCode code) {
		switch (code.getPermission()) {
		case ALL:
			PlayerManager.getPlayers().forEach(p -> sendMessage(p, code));
			break;
		case COMMAND_SENDER:
			sendMessage((Player) player, code);
			break;
		case OPERATORS:
			BukkitManager.getOnlineOperators().forEach(p -> sendMessage(p, code));
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
