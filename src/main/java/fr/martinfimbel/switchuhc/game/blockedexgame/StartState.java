package fr.martinfimbel.switchuhc.game.blockedexgame;

import org.bukkit.Material;

import fr.martinfimbel.switchuhc.game.blockedexgame.object.BlocksToFind;
import fr.martinfimbel.switchuhc.managers.BaseManager;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class StartState extends AbstractBlockedexState {

	public StartState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void start() {
		onStart();
		WorldManager.createCrossUnderSpawn(Material.BEDROCK);
		BaseManager.launchBlockedexBases();
		TeamsManager.teleporteRandomlyAllTeams(getConfiguration(), getConfiguration().getDiameterAreaOnPlayerRespawn());
		BlocksToFind.initialize();
		taskLauncher.run(0, 20L);
		scoreboardLauncher.run(0, getConfiguration().getScoreboardRefresh());
		game.setCurrentState(game.getStarted());
	}
}
