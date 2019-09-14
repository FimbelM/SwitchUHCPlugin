package fr.pederobien.uhc.game.hungergame;

import org.bukkit.GameMode;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StartState extends AbstractState {

	public StartState(IHungerGame game) {
		super(game);
	}

	@Override
	public void start() {
		PlayerManager.giveEffects("@a", "resistance", "regeneration", "saturation");
		PlayerManager.maxFoodForPlayers();
		PlayerManager.maxLifeToPlayers();
		PlayerManager.removeInventoryOfPlayers();
		PlayerManager.setGameModeOfPlayers(GameMode.SURVIVAL);
		WorldManager.setTimeDay();
		WorldManager.setWeatherSun();
		WorldManager.setPVP(true);
		WorldManager.setWorldBorderDiameter(game.getConfiguration().getInitialBorderDiameter());
		TeamsManager.teleporteRandomlyAllTeams();
		BukkitManager.broadcastMessageAsTitle("Match à mort par équipe");
		taskLauncher.runTaskTimer(PluginDeposit.plugin, 0, 20L);
		scoreboardLauncher.start();
		scoreboardLauncher.runTaskTimer(PluginDeposit.plugin, 0, game.getConfiguration().getScoreboardRefresh());
		game.setCurrentState(game.getPlayerRevive());
	}
}
