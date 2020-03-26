package fr.martinfimbel.switchuhc.game.blockedexgame;

import fr.martinfimbel.switchuhc.game.AbstractGameState;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.martinfimbel.switchuhc.managers.BaseManager;
import fr.martinfimbel.switchuhc.managers.BlockedexPlayerManager;
import fr.martinfimbel.switchuhc.task.TimeLine;

public abstract class AbstractBlockedexState extends AbstractGameState<IUnmodifiableBlockedexConfiguration> implements IBlockedexGameState {
	protected IBlockedexGame game;
	protected static TimeLine timeLine;
	protected static BlockedexPlayerManager bdPlayerManager;
	protected static BaseManager baseManager;

	public AbstractBlockedexState(IBlockedexGame game) {
		super(game.getConfiguration());
		this.game = game;
	}
}
