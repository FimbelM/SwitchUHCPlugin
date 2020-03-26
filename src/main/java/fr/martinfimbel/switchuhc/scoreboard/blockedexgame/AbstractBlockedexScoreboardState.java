package fr.martinfimbel.switchuhc.scoreboard.blockedexgame;

import org.bukkit.block.Block;

import fr.martinfimbel.switchuhc.scoreboard.AbstractScoreboardState;
import fr.martinfimbel.switchuhc.scoreboard.ScoreboardStateException;

public abstract class AbstractBlockedexScoreboardState extends AbstractScoreboardState implements IBDScoreboardState {
	protected IBDScoreboard scoreboard;

	public AbstractBlockedexScoreboardState(IBDScoreboard scoreboard, String title) {
		super(scoreboard, title);
		this.scoreboard = scoreboard;
	}

	@Override
	public void pause(IBDScoreboardState before) {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}

	protected String showBlock(Block block) {
		return block.getX() + " " + block.getY() + " " + block.getZ();
	}
}
