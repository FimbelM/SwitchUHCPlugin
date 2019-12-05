package fr.pederobien.uhc.dictionary;

import java.util.List;
import java.util.Locale;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public interface IDictionary {

	List<Locale> getLocale();

	String getMessage(MessageCode code);

	IDictionary registerMessage(IPlayerMessage message);
}
