package fr.pederobien.uhc.event;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class MessageCodeEvent {
	private MessageCode code;
	private String[] args;
	
	public MessageCodeEvent(MessageCode code, String... args) {
		this.code = code;
		this.args = args;
	}
	
	public MessageCode getCode() {
		return code;
	}
	
	public String[] getArgs() {
		return args;
	}
}
