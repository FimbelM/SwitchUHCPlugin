package fr.pederobien.uhc.game.hungergame;

public class HungerGameState extends AbstractState {

	public HungerGameState(IGame game) {
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
