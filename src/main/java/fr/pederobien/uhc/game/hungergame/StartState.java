package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.managers.WorldManager;

public class StartState extends AbstractState {

	public StartState(IHungerGame game) {
		super(game);
	}

	@Override
	public void start() {
		BukkitManager.broadcastMessageAsTitle("Match à mort par équipe");
		taskLauncher.runTaskTimer(PluginDeposit.plugin, 0, 20L);
		scoreboard.start();
		scoreboardLauncher.runTaskTimer(PluginDeposit.plugin, 0, game.getConfiguration().getScoreboardRefresh());
		game.setCurrentState(game.getPlayerRevive());
		WorldManager.setWorldBorderCenter(game.getConfiguration().getSpawn().getCenter());
		WorldManager.setWorldBorderDiameter(game.getConfiguration().getInitialBorderSize());
	}
}
