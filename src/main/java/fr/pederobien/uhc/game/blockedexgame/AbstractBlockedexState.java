package fr.pederobien.uhc.game.blockedexgame;

import fr.pederobien.uhc.game.AbstractGameState;
import fr.pederobien.uhc.managers.BlockedexPlayerManager;
import fr.pederobien.uhc.task.TimeLine;

public abstract class AbstractBlockedexState extends AbstractGameState implements IBlockedexGameState {
	protected IBlockedexGame game;
	protected static TimeLine timeLine;
	protected static BlockedexPlayerManager bdPlayerManager;

	public AbstractBlockedexState(IBlockedexGame game) {
		this.game = game;
	}
}
