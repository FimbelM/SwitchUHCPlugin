package fr.pederobien.uhc.game;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.PluginDeposit;

public class StartState extends AbstractState {

	public StartState(IGame game) {
		super(game);
	}
	
	@Override
	public void start() {
		BukkitManager.broadcastMessageAsTitle("Match à mort par équipe");
		launcher.runTaskTimer(PluginDeposit.plugin, 0, 1);
		game.setCurrentState(game.getPlayerRevive());
	}
}
