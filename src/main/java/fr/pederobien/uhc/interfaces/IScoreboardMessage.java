package fr.pederobien.uhc.interfaces;

public interface IScoreboardMessage {

	IMessageCode getCode();

	boolean toTranslate();

	String getKey();

	String getMessage();
}
