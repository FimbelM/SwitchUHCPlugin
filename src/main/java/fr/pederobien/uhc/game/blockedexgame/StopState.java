package fr.pederobien.uhc.game.blockedexgame;

public class StopState extends AbstractBlockedexState {

	public StopState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void stop() {
		onStop();
		game.setCurrentState(game.getInitiate()).initiate();
	}
}
