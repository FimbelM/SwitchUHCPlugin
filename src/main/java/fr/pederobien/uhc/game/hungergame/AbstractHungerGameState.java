package fr.pederobien.uhc.game.hungergame;

import java.time.LocalTime;

import org.bukkit.GameMode;

import fr.pederobien.uhc.game.AbstractGameState;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.task.TimeLine;

public abstract class AbstractHungerGameState extends AbstractGameState implements IHungerGameState {
	protected IHungerGame game;
	protected static TimeLine timeLine;
	protected static LocalTime warningTime;

	public AbstractHungerGameState(IHungerGame game) {
		this.game = game;
	}
	
	protected void shouldStopGame() {
		if (PlayerManager.getNumberOfPlayersOnMode(GameMode.SURVIVAL) == 0)
			game.stop();
	}
	
	protected boolean warnPlayer(LocalTime time) {
		boolean b = time.equals(warningTime);
		if (b)
			PlayerManager.sendMessageToPlayers(WorldManager.getPlayersInWorld(WorldManager.NETHER_WORLD, WorldManager.END_WORLD), "Go back to the surface or you will die in 1 minute");
		return b;
	}
}
