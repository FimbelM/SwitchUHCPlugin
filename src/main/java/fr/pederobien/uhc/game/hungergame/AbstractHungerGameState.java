package fr.pederobien.uhc.game.hungergame;

import java.time.LocalTime;

import org.bukkit.GameMode;

import fr.pederobien.uhc.game.AbstractGameState;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.task.TimeLine;

public abstract class AbstractHungerGameState extends AbstractGameState implements IHungerGameState {
	protected static TimeLine timeLine;
	protected static boolean alreadyWarned;
	protected IHungerGame game;

	public AbstractHungerGameState(IHungerGame game) {
		this.game = game;
		alreadyWarned = false;
	}

	protected void shouldStopGame() {
		if (PlayerManager.getNumberOfPlayersOnMode(GameMode.SURVIVAL) == 1)
			stop();
	}
	
	protected void warnPlayers() {
		if (!alreadyWarned)
		PlayerManager.sendMessageToPlayers(WorldManager.getPlayersInWorld(WorldManager.NETHER_WORLD, WorldManager.END_WORLD),
				"Go back to the surface or you will die in " + showTime(game.getConfiguration().getWarningTime()));
		alreadyWarned = false;
	}
	
	protected String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}
}
