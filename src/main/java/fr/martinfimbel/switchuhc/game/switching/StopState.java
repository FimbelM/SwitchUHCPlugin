package fr.martinfimbel.switchuhc.game.switching;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.ScoreboardKillManager;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class StopState extends AbstractSwitchGameState {

	public StopState(ISwitchGame game) {
		super(game);
	}

	@Override
	public void stop() {
		onStop();
		for (ITeam team : getConfiguration().getTeams()) {
			for (Player p : team.getPlayers()) {
				p.setPlayerListName(p.getName() + ChatColor.DARK_RED + " Kills : " + ChatColor.DARK_RED
						+ ScoreboardKillManager.getkill(p).toString());
			}
		}
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
