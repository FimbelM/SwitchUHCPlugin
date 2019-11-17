package fr.pederobien.uhc.game.blockedexgame;

import org.bukkit.GameMode;

import fr.pederobien.uhc.managers.BaseManager;
import fr.pederobien.uhc.managers.PlayerManager;

public class StopState extends AbstractBlockedexState {

	public StopState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void stop() {
		onStop();
		PlayerManager.setGameModeOfPlayers(GameMode.ADVENTURE);
		BaseManager.removeBlockedexBases();
		game.setCurrentState(game.getInitiate()).initiate();
	}
}
