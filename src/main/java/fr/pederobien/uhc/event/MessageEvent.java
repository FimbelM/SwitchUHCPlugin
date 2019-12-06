package fr.pederobien.uhc.event;

import org.bukkit.command.CommandSender;

public class MessageEvent extends MessageCodeEvent {
	private CommandSender sender;

	public MessageEvent(CommandSender sender, MessageCodeEvent event) {
		super(event.getCode(), event.getArgs());
		this.sender = sender;
	}

	public CommandSender getSender() {
		return sender;
	}
}
