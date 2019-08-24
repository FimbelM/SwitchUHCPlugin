package fr.pederobien.uhc.game;

public class PlayerReviveState extends AbstractState {

	public PlayerReviveState(IGame game) {
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
