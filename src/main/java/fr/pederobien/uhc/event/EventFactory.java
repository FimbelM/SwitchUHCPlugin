package fr.pederobien.uhc.event;

import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.managers.EColor;

public class EventFactory {

	public static MessageCodeEvent createMessageCodeEvent(IMessageCode code, String... args) {
		return new MessageCodeEvent(code, args);
	}

	public static MessageEvent createMessageEvent(CommandSender sender, MessageCodeEvent event) {
		return new MessageEvent(sender, event);
	}

	public static MessageEvent createMessageEvent(CommandSender sender, IMessageCode code, String... args) {
		return new MessageEvent(sender, createMessageCodeEvent(code, args));
	}

	public static PlayerInteractEventResponse createPlayerInteractEventResponse(boolean restricted, EColor colorAllowed) {
		return new PlayerInteractEventResponse(restricted, colorAllowed);
	}
}
