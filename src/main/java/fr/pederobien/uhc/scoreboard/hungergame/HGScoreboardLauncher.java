package fr.pederobien.uhc.scoreboard.hungergame;

import org.bukkit.entity.Player;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.scoreboard.AbstractScoreboardLauncher;
import fr.pederobien.uhc.task.TimeTask;

public class HGScoreboardLauncher extends AbstractScoreboardLauncher{
	
	public HGScoreboardLauncher(TimeTask task) {
		super(task);
	}

	@Override
	protected void initialize() {
		for (Player player : PlayerManager.getPlayers())
			getScoreboards().add(new HungerGameScoreboard(player, task));
	}
}
