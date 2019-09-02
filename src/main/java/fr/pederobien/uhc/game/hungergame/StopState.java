package fr.pederobien.uhc.game.hungergame;

import org.bukkit.GameMode;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StopState extends AbstractState {

	public StopState(IHungerGame game) {
		super(game);
	}
	
	@Override
	public void stop() {
		taskLauncher.cancel();
		scoreboardLauncher.cancel();
		PlayerManager.setGameModeOfPlayers(GameMode.ADVENTURE);
		TeamsManager.teleporteAllPlayers(WorldManager.getSpawnOnJoin());
		game.setCurrentState(game.getInitiate()).initiate();
	}
}
