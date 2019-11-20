package fr.pederobien.uhc.game.blockedexgame;

import fr.pederobien.uhc.managers.BaseManager;

public class StartState extends AbstractBlockedexState {

	public StartState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void start() {
		onStart();
		BaseManager.launchBlockedexBases();
		taskLauncher.run(0, 20L);
		scoreboardLauncher.run(0, game.getConfiguration().getScoreboardRefresh());
		game.setCurrentState(game.getStarted());
	}
}
