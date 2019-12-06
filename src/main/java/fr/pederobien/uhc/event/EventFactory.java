package fr.pederobien.uhc.event;

import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class EventFactory {
	
	public static MessageCodeEvent createMessageCodeEvent(MessageCode code, String... args) {
		return new MessageCodeEvent(code, args);
	}
	
	public static MessageEvent createMessageEvent(CommandSender sender, MessageCodeEvent event) {
		return new MessageEvent(sender, event);
	}
	
	public static MessageEvent createMessageEvent(CommandSender sender, MessageCode code, String... args) {
		return new MessageEvent(sender, createMessageCodeEvent(code, args));
	}
}
