package fr.pederobien.uhc.game.hungergame;

import org.bukkit.Material;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StartState extends AbstractHungerGameState {

	public StartState(IHungerGame game) {
		super(game);
	}

	@Override
	public void start() {
		onStart();
		WorldManager.setPVP(false);
		WorldManager.setWorldBorderCenter(getConfiguration().getBorderCenter());
		WorldManager.setWorldBorderDiameter(getConfiguration().getInitialBorderDiameter());
		WorldManager.createCrossUnderSpawn(Material.BEDROCK);
		TeamsManager.createTeams(getConfiguration().getTeams());
		TeamsManager.teleporteRandomlyAllTeams(getConfiguration(), getConfiguration().getInitialBorderDiameter().intValue());
		sendTitle(MessageCode.TEAM_DEATH_MATCH);
		taskLauncher.run(0, 20L);
		scoreboardLauncher.run(0, getConfiguration().getScoreboardRefresh());
		game.setCurrentState(game.getPlayerRevive());
	}
}
