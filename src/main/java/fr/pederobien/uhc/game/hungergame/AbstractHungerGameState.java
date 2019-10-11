package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.game.AbstractGameState;
import fr.pederobien.uhc.task.TimeLine;

public abstract class AbstractHungerGameState extends AbstractGameState implements IHungerGameState {
	protected IHungerGame game;
	protected static TimeLine timeLine;

	public AbstractHungerGameState(IHungerGame game) {
		this.game = game;
	}
}
