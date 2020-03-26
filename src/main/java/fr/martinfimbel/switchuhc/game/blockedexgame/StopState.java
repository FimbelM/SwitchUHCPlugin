package fr.martinfimbel.switchuhc.game.blockedexgame;

import org.bukkit.GameMode;

import fr.martinfimbel.switchuhc.managers.BaseManager;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class StopState extends AbstractBlockedexState {

	public StopState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void stop() {
		onStop();
		WorldManager.removeCrossUnderSpawn();
		PlayerManager.setGameModeOfAllPlayers(GameMode.ADVENTURE);
		BaseManager.removeBlockedexBases();
		game.setCurrentState(game.getInitiate()).initiate();
	}
}
