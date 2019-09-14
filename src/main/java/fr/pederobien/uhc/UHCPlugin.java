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
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.observer.IObsGame;
import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.world.EventListener;
import fr.pederobien.uhc.world.IListener;

public class UHCPlugin extends JavaPlugin implements IObsListener, IObsGame {
	private IConfigurationContext context;
	private IListener listener;
	
	@Override
	public void onEnable() {
		getLogger().info("UHC plugin enable");
		
		PluginDeposit.plugin = this;
		context = new ConfigurationContext();
		listener = new EventListener();
		
		AbstractCommand.setConfigurationContext(context);
		AbstractCommand.setListener(listener);
		
		new PauseCommand(this, "pausegame");
		new StartCommand(this, "startgame");
		new StopCommand(this, "stopgame");
		new AddToRandomTeamCommand(this, "teamrandom");
		new CreateTeamCommand(this, "teamcreate");
		new RemoveAllTeamCommand(this, "teamremoveall");
		new HungerGameConfigurationCommand(this, "hg");
		new SpawnConfigurationCommand(this, "spawn");
		
		getServer().getPluginManager().registerEvents(listener, this);
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
		listener.removeObservers(this);
		listener.addObservers(context);
	}
	
	@Override
	public void onStop() {
		listener.addObservers(this);
		listener.removeObservers(context);
	}
}
