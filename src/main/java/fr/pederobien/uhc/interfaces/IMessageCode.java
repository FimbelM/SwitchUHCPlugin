package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.dictionary.dictionaries.MessagePermission;

public interface IMessageCode {

	public MessagePermission getPermission();

	public void setPermission(MessagePermission permission);
}
