package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.BukkitManager;

public class PauseState extends AbstractState {
	private IGameState before;
	public PauseState(IGame game) {
		super(game);
	}
	
	@Override
	public void pause(IGameState before) {
		BukkitManager.broadcastMessageAsTitle("Partie suspendue");
		taskLauncher.pause();
		scoreboard.pause(scoreboard.getCurrentState());
		this.before = before;
	}
	
	@Override
	public void relaunched() {
		BukkitManager.broadcastMessageAsTitle("Reprise");
		taskLauncher.relaunched();
		scoreboard.relaunched();
		game.setCurrentState(before);
	}
}
