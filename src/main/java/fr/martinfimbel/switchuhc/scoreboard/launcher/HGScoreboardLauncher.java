package fr.martinfimbel.switchuhc.scoreboard.launcher;

import fr.martinfimbel.switchuhc.game.hungergame.IHungerGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;
import fr.martinfimbel.switchuhc.scoreboard.hungergame.HungerGameScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public class HGScoreboardLauncher extends AbstractScoreboardLauncher<IUnmodifiableHungerGameConfiguration, IHungerGame> {

	public HGScoreboardLauncher(TimeTask task, IUnmodifiableHungerGameConfiguration configuration, IHungerGame game) {
		super(task, configuration, game);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new HungerGameScoreboard(getTask(), getConfiguration());
	}
}
