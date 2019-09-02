package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StartState extends AbstractState {

	public StartState(IHungerGame game) {
		super(game);
	}

	@Override
	public void start() {
		WorldManager.setTimeDay();
		WorldManager.setWeatherSun();
		TeamsManager.teleporteRandomlyAllTeams();
		BukkitManager.broadcastMessageAsTitle("Match à mort par équipe");
		taskLauncher.runTaskTimer(PluginDeposit.plugin, 0, 20L);
		scoreboard.start();
		scoreboardLauncher.runTaskTimer(PluginDeposit.plugin, 0, game.getConfiguration().getScoreboardRefresh());
		WorldManager.setWorldBorderCenter(game.getConfiguration().getSpawn().getCenter());
		WorldManager.setWorldBorderDiameter(game.getConfiguration().getInitialBorderSize());
		WorldManager.setPVP(true);
		game.setCurrentState(game.getPlayerRevive());
	}
}
