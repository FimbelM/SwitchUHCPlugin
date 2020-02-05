package fr.pederobien.uhc.game.blockedexgame;

import org.bukkit.Material;

import fr.pederobien.uhc.game.blockedexgame.object.BlocksToFind;
import fr.pederobien.uhc.managers.BaseManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

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
