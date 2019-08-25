package fr.pederobien.uhc.game;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.managers.WorldManager;

public class StartState extends AbstractState {

	public StartState(IGame game) {
		super(game);
	}
	
	@Override
	public void start() {
		BukkitManager.broadcastMessageAsTitle("Match à mort par équipe");
		launcher.runTaskTimer(PluginDeposit.plugin, 0, 1);
		scoreboard.start();
		game.setCurrentState(game.getPlayerRevive());
		
		WorldManager.setWorldBorderCenter(game.getConfiguration().getSpawn().getCenter());
		WorldManager.setWorldBorderDiameter(game.getConfiguration().getBorderSize());
	}
}
