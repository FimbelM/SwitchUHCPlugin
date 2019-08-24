package fr.pederobien.uhc.game;

import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitiateState extends AbstractState {
	private boolean initiate;
	
	public InitiateState(IGame game) {
		super(game);
		initiate = false;
	}
	
	@Override
	public void initiate() {
		if (initiate) return;
		
		launcher = new TaskLauncher(game.getConfiguration().getGameTime(), game.getConfiguration().getFractionTime());
		timeLine = new TimeLine(launcher.getTask());
		timeLine.addObserver(game.getConfiguration().getGameTime(), game);
		timeLine.addObserver(game.getConfiguration().getFractionTime(), game);
		initiate = true;
	}
	
	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
