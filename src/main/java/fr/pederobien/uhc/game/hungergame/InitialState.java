package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.task.ScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitialState extends AbstractState {
	
	public InitialState(IHungerGame game) {
		super(game);
	}
	
	@Override
	public void initiate() {
		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime(), game.getConfiguration().getFractionTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new ScoreboardLauncher(taskLauncher.getTask());
		
		timeLine.addObserver(game.getConfiguration().getGameTime(), game);
		timeLine.addObserver(game.getConfiguration().getFractionTime(), game);
		timeLine.addObserver(game.getConfiguration().getGameTime(), scoreboardLauncher);
				
		WorldManager.setPVP(false);
	}
	
	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
