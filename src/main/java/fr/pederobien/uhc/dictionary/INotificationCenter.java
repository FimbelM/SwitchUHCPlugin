package fr.pederobien.uhc.dictionary;

import java.util.Locale;

import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public interface INotificationCenter {

	INotificationCenter sendMessage(Locale locale, CommandSender sender, MessageCode message);
}
