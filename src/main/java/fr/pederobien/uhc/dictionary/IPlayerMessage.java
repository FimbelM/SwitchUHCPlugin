package fr.pederobien.uhc.dictionary;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public interface IPlayerMessage {

	MessageCode getCode();

	String getMessage();
}
