package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.game.AbstractState;
import fr.pederobien.uhc.scoreboard.hungergame.HGScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class AbstractHungerGameState extends AbstractState implements IHungerGameState {
	protected IHungerGame game;
	protected static TaskLauncher taskLauncher;
	protected static HGScoreboardLauncher scoreboardLauncher;
	protected static TimeLine timeLine;

	public AbstractHungerGameState(IHungerGame game) {
		this.game = game;
	}
}
