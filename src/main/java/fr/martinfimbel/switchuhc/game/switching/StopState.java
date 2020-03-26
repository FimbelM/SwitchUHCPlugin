package fr.martinfimbel.switchuhc.game.switching;

import org.bukkit.GameMode;

import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class StopState extends AbstractSwitchGameState {

	public StopState(ISwitchGame game) {
		super(game);
	}

	@Override
	public void stop() {
		onStop();
		TeamsManager.removeTeams(getConfiguration().getTeams());
		PlayerManager.setGameModeOfAllPlayers(GameMode.CREATIVE);
		WorldManager.removeBorder();
		WorldManager.removeCrossUnderSpawn();
	}

	@Override
	public boolean initiate() {
		return game.setCurrentState(game.getInitiate()).initiate();
	}
}
