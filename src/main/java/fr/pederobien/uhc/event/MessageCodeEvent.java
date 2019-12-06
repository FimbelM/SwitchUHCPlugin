package fr.pederobien.uhc.event;

import fr.pederobien.uhc.interfaces.IMessageCode;

public class MessageCodeEvent {
	private IMessageCode code;
	private String[] args;

	public MessageCodeEvent(IMessageCode code, String... args) {
		this.code = code;
		this.args = args;
	}

	public IMessageCode getCode() {
		return code;
	}

	public String[] getArgs() {
		return args;
	}
}
