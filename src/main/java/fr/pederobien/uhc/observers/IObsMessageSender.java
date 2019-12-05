package fr.pederobien.uhc.observers;

import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public interface IObsMessageSender {
	
	void sendMessage(CommandSender sender, MessageCode code);	
}
