package fr.pederobien.uhc.game.hungergame;

import org.bukkit.GameMode;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StopState extends AbstractHungerGameState {

	public StopState(IHungerGame game) {
		super(game);
	}

	@Override
	public void stop() {
		onStop();
		PlayerManager.setGameModeOfPlayers(GameMode.CREATIVE);
		WorldManager.removeBorder();
		game.setCurrentState(game.getInitiate()).initiate();
	}
}
