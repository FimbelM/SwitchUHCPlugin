package fr.martinfimbel.switchuhc.game.hungergame;

import java.time.LocalTime;

import org.bukkit.GameMode;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.game.AbstractGameState;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.martinfimbel.switchuhc.managers.EColor;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;
import fr.martinfimbel.switchuhc.task.TimeLine;

public abstract class AbstractHungerGameState extends AbstractGameState<IUnmodifiableHungerGameConfiguration> implements IHungerGameState {
	protected static TimeLine timeLine;
	protected static boolean alreadyWarned;
	protected IHungerGame game;

	public AbstractHungerGameState(IHungerGame game) {
		super(game.getConfiguration());
		this.game = game;
	}

	protected void shouldStopGame() {
		if (PlayerManager.getNumberOfPlayersOnMode(GameMode.SURVIVAL) == 1)
			stop();
	}

	protected void authorizedPvp() {
		sendTitle(EColor.DARK_RED, MessageCode.PVP_ENABLED);
		WorldManager.setPVP(true);
	}

	protected void warnPlayers() {
		if (!alreadyWarned)
			warn(getConfiguration().getWarningTime());
		alreadyWarned = true;
	}

	protected void warn(LocalTime time) {
		WorldManager.getPlayersInWorld(WorldManager.NETHER_WORLD, WorldManager.END_WORLD)
				.forEach(p -> sendMessage(p, MessageCode.PLAYER_MUST_GO_BACK_TO_THE_OVERWORLD, "" + time.getHour(), "" + time.getMinute(), "" + time.getSecond()));
	}

	protected LocalTime getAbsoluteWarningTime() {
		return getConfiguration().getGameTime().minusSeconds(getConfiguration().getWarningTime().toSecondOfDay());
	}
}
