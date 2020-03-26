package fr.martinfimbel.switchuhc.dictionary;

import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public interface IPlayerMessage {

	IMessageCode getCode();

	String getMessage(String... args);
}
