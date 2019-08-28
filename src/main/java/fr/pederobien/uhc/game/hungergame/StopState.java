package fr.pederobien.uhc.game.hungergame;

public class StopState extends AbstractState {

	public StopState(IGame game) {
		super(game);
	}
	
	@Override
	public void stop() {
		System.out.println("Stopping game");
		taskLauncher.cancel();
		scoreboardLauncher.cancel();
		game.setCurrentState(game.getInitiate()).initiate();
	}
}
