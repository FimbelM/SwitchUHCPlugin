package fr.pederobien.uhc.game;

public class PlayerDontReviveState extends AbstractState {

	public PlayerDontReviveState(IGame game) {
		super(game);
	}
	
	@Override
	public void pause(IGameState before) {
		game.setCurrentState(game.getPause()).pause(before);
	}
	
	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}
}
