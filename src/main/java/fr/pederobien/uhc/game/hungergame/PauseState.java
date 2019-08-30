package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.BukkitManager;

public class PauseState extends AbstractState {
	private IHungerGameState before;
	public PauseState(IHungerGame game) {
		super(game);
	}
	
	@Override
	public void pause(IHungerGameState before) {
		BukkitManager.broadcastMessageAsTitle("Partie suspendue");
		taskLauncher.pause();
		scoreboard.pause(scoreboard.getCurrentState());
		this.before = before;
	}
	
	@Override
	public void relaunch() {
		BukkitManager.broadcastMessageAsTitle("Reprise");
		taskLauncher.relaunched();
		scoreboard.relaunched();
		game.setCurrentState(before);
	}
}
