package fr.pederobien.uhc;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.HungerGameConfigurationCommand;
import fr.pederobien.uhc.commands.configuration.SpawnConfigurationCommand;
import fr.pederobien.uhc.commands.game.PauseCommand;
import fr.pederobien.uhc.commands.game.StartCommand;
import fr.pederobien.uhc.commands.game.StopCommand;
import fr.pederobien.uhc.commands.team.AddToRandomTeamCommand;
import fr.pederobien.uhc.commands.team.CreateTeamCommand;
import fr.pederobien.uhc.commands.team.RemoveAllTeamCommand;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.observer.IObsGame;
import fr.pederobien.uhc.observer.IObsListener;

public class UHCPlugin extends JavaPlugin implements IObsListener, IObsGame {

	@Override
	public void onEnable() {
		getLogger().info("UHC plugin enable");
		
		PluginDeposit.plugin = this;
		
		new PauseCommand(this, "pausegame");
		new StartCommand(this, "startgame");
		new StopCommand(this, "stopgame");
		new AddToRandomTeamCommand(this, "teamrandom");
		new CreateTeamCommand(this, "teamcreate");
		new RemoveAllTeamCommand(this, "teamremoveall");
		new HungerGameConfigurationCommand(this, "hg");
		new SpawnConfigurationCommand(this, "spawn");
		
		getServer().getPluginManager().registerEvents(AbstractCommand.listener, this);
	}

	@Override
	public void onDisable() {
		getLogger().info("UHC plugin disable");
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		movePlayer(event.getPlayer());
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		movePlayer(event.getPlayer());
	}
	
	private void movePlayer(Player player) {
		TeamsManager.teleporte(player.getName(), WorldManager.getSpawnOnJoin());
		PlayerManager.setGameModeOfPlayer(player, GameMode.ADVENTURE);
	}
	
	@Override
	public void onStart() {
		AbstractCommand.listener.removeObservers(this);
	}
	
	@Override
	public void onStop() {
		AbstractCommand.listener.addObservers(this);
	}
}
