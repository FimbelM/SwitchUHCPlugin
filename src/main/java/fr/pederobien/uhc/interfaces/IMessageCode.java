package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.dictionary.dictionaries.MessagePermission;

public interface IMessageCode {

	public IMessageCode withArgs(String... args);

	public String[] getArgs();
	
	public MessagePermission getPermission();
	
	public void setPermission(MessagePermission permission);
}
