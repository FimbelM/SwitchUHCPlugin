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
		BukkitManager.broadcastMessageAsTitle("Match � mort par �quipe");
		taskLauncher.runTaskTimer(PluginDeposit.plugin, 0, 20L);
		scoreboardLauncher.start();
		scoreboardLauncher.runTaskTimer(PluginDeposit.plugin, 0, game.getConfiguration().getScoreboardRefresh());
		WorldManager.setWorldBorderDiameter(game.getConfiguration().getInitialBorderDiameter());
		WorldManager.setPVP(true);
		game.setCurrentState(game.getPlayerRevive());
	}
}
