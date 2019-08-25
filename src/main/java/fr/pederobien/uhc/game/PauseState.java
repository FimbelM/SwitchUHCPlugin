package fr.pederobien.uhc.game;

import fr.pederobien.uhc.BukkitManager;

public class PauseState extends AbstractState {
	private IGameState before;
	public PauseState(IGame game) {
		super(game);
	}
	
	@Override
	public void pause(IGameState before) {
		BukkitManager.broadcastMessageAsTitle("Partie suspendue");
		launcher.pause();
		scoreboard.pause(scoreboard.getCurrentState());
		this.before = before;
	}
	
	@Override
	public void relaunched() {
		BukkitManager.broadcastMessageAsTitle("Reprise");
		launcher.relaunched();
		scoreboard.relaunched();
		game.setCurrentState(before);
	}
}
