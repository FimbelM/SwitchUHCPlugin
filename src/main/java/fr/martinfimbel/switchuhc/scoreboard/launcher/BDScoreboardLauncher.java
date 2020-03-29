package fr.martinfimbel.switchuhc.scoreboard.launcher;

import fr.martinfimbel.switchuhc.game.blockedexgame.IBlockedexGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;
import fr.martinfimbel.switchuhc.scoreboard.blockedexgame.BlockedexScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public class BDScoreboardLauncher extends AbstractScoreboardLauncher<IUnmodifiableBlockedexConfiguration,IBlockedexGame> {

	public BDScoreboardLauncher(TimeTask task, IUnmodifiableBlockedexConfiguration configuration, IBlockedexGame game) {
		super(task, configuration, game);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new BlockedexScoreboard(getTask(), getConfiguration());
	}
}
