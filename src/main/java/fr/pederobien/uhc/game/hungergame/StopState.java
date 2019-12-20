package fr.pederobien.uhc.game.hungergame;

import org.bukkit.GameMode;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StopState extends AbstractHungerGameState {

	public StopState(IHungerGame game) {
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
