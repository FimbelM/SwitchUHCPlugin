package fr.martinfimbel.switchuhc.dictionary;

import java.util.Locale;

import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public interface INotificationCenter {

	INotificationCenter sendMessage(Locale locale, CommandSender sender, MessageCode message);
}
