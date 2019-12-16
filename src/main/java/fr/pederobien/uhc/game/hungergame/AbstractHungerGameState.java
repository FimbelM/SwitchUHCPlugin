package fr.pederobien.uhc.game.hungergame;

import java.time.Duration;
import java.time.LocalTime;

import org.bukkit.GameMode;

import fr.pederobien.uhc.dictionary.NotificationCenter;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.game.AbstractGameState;
import fr.pederobien.uhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.task.TimeLine;

public abstract class AbstractHungerGameState extends AbstractGameState implements IHungerGameState {
	protected static TimeLine timeLine;
	protected static boolean alreadyWarned;
	protected IHungerGame game;

	public AbstractHungerGameState(IHungerGame game) {
		this.game = game;
	}

	protected void shouldStopGame() {
		if (PlayerManager.getNumberOfPlayersOnMode(GameMode.SURVIVAL) == 1)
			stop();
	}

	protected void authorizedPvp() {
		sendTitle(EColor.DARK_RED, MessageCode.PVP_ALLOWED);
		WorldManager.setPVP(true);
	}

	protected void warnPlayers(LocalTime time) {
		if (!alreadyWarned) {
			LocalTime toMovingBorder = LocalTime.ofNanoOfDay(Duration.between(time, getConfiguration().getGameTime()).toNanos());

			WorldManager.getPlayersInWorld(WorldManager.NETHER_WORLD, WorldManager.END_WORLD)
					.forEach(p -> NotificationCenter.sendMessage(EventFactory.createMessageEvent(p, MessageCode.PLAYER_MUST_GO_BACK_TO_THE_OVERWORLD,
							"" + toMovingBorder.getHour(), "" + toMovingBorder.getMinute(), "" + toMovingBorder.getSecond())));
		}
		alreadyWarned = true;
	}

	protected IUnmodifiableHungerGameConfiguration getConfiguration() {
		return game.getConfiguration();
	}
}
