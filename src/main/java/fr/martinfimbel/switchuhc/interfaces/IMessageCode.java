package fr.martinfimbel.switchuhc.interfaces;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessagePermission;

public interface IMessageCode {

	public MessagePermission getPermission();

	public void setPermission(MessagePermission permission);
}
