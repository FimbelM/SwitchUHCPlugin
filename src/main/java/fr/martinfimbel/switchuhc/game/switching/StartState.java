package fr.martinfimbel.switchuhc.game.switching;

import org.bukkit.Material;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class StartState extends AbstractSwitchGameState {
	public StartState(ISwitchGame game) {
		super(game);
	}

	@Override
	public void start() {
		onStart();
		WorldManager.setWorldBorderCenter(getConfiguration().getBorderCenter());
		WorldManager.setWorldBorderDiameter(getConfiguration().getInitialBorderDiameter());
		WorldManager.createCrossUnderSpawn(Material.BEDROCK);
		TeamsManager.teleporteRandomlyAllTeams(getConfiguration(),
				getConfiguration().getInitialBorderDiameter().intValue());
		sendTitle(MessageCode.TEAM_DEATH_MATCH);
		taskLauncher.run(0, 20L);
		scoreboardLauncher.run(0, getConfiguration().getScoreboardRefresh());
		game.setCurrentState(game.getPlayerRevive());

	}
}
