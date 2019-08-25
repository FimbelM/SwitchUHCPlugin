package fr.pederobien.uhc.game;

public class StopState extends AbstractState {

	public StopState(IGame game) {
		super(game);
	}
	
	@Override
	public void stop() {
		taskLauncher.cancel();
		scoreboardLauncher.cancel();
		game.setCurrentState(game.getInitiate());
	}
}
