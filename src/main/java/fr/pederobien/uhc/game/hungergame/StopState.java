package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.managers.WorldManager;

public class StopState extends AbstractHungerGameState {

	public StopState(IHungerGame game) {
		super(game);
	}

	@Override
	public void stop() {
		onStop();
		WorldManager.removeBorder();
		game.setCurrentState(game.getInitiate()).initiate();
	}
}
