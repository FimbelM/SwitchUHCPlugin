package fr.pederobien.uhc.dictionary;

import fr.pederobien.uhc.interfaces.IMessageCode;

public interface IPlayerMessage {

	IMessageCode getCode();

	String getMessage(String... args);
}
