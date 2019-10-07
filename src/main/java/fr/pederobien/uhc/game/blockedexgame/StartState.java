package fr.pederobien.uhc.game.blockedexgame;

public class StartState extends AbstractBlockedexState {

	public StartState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void start() {
		onStart();
		taskLauncher.run(0, 20L);
		scoreboardLauncher.run(0, game.getConfiguration().getScoreboardRefresh());
		game.setCurrentState(game.getStarted());
	}
}
