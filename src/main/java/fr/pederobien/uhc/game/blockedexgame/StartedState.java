package fr.pederobien.uhc.game.blockedexgame;

public class StartedState extends AbstractBlockedexState {

	public StartedState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}
}
