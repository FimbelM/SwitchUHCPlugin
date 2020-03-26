package fr.martinfimbel.switchuhc.interfaces;

public interface IScoreboardMessage {

	IMessageCode getCode();

	boolean toTranslate();

	String getKey();

	String getMessage();
}
