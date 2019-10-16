package fr.pederobien.uhc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.BlockedexConfigurationCommand;
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
import fr.pederobien.uhc.game.GameStateException;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.observer.IObsGame;
import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.scoreboard.ScoreboardStateException;
import fr.pederobien.uhc.world.EventListener;

public class UHCPlugin extends JavaPlugin implements IObsListener, IObsGame {
	private IConfigurationContext context;
	private EventListener listener;
	private List<PotionEffect> effects;

	@Override
	public void onEnable() {
		getLogger().info("UHC plugin enable");

		PluginDeposit.plugin = this;
		context = new ConfigurationContext();
		listener = new EventListener();

		getServer().getPluginManager().registerEvents(listener, this);

		AbstractCommand.setConfigurationContext(context);
		AbstractCommand.setListener(listener);

		WorldManager.setPVP(false);

		new PauseCommand(this, "pausegame");
		new StartCommand(this, "startgame");
		new StopCommand(this, "stopgame");
		new AddToRandomTeamCommand(this, "teamrandom");
		new CreateTeamCommand(this, "teamcreate");
		new RemoveAllTeamCommand(this, "teamremoveall");
		new HungerGameConfigurationCommand(this, "hg");
		new SpawnConfigurationCommand(this, "spawn");
		new BlockedexConfigurationCommand(this, "bd");

		listener.addObservers(this);

		initialEffects();
	}

	@Override
	public void onDisable() {
		getLogger().info("UHC plugin disable");
		try {
			context.stop();
		} catch (GameStateException | ScoreboardStateException | NullPointerException e) {

		}
	}

	@Override
	public void onStart() {
		PlayerManager.removeAllEffectsToAllPlayers();
		listener.removeObservers(this);
		listener.addObservers(context);
		WorldManager.setPVP(true);
	}

	@Override
	public void onStop() {
		listener.addObservers(this);
		listener.removeObservers(context);
		WorldManager.setPVP(false);
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		PlayerManager.teleporte(event.getPlayer(), WorldManager.getSpawnOnJoin());
		movePlayer(event.getPlayer());
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {

	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {

	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		movePlayer(event.getPlayer());
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {

	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {

	}

	@Override
	public void onCreatureSpawn(CreatureSpawnEvent event) {

	}

	@Override
	public void onPlayerPortalEvent(PlayerPortalEvent event) {

	}

	private void movePlayer(Player player) {
		PlayerManager.setGameModeOfPlayer(player, GameMode.ADVENTURE);
		PlayerManager.giveEffects(player, effects);
	}

	private void initialEffects() {
		effects = new ArrayList<PotionEffect>();
		effects.add(PlayerManager.createEffect(PotionEffectType.REGENERATION, PlayerManager.MAX_EFFECT_DURATION,
				PlayerManager.MAX_EFFECT_AMPLIFIER));
		effects.add(PlayerManager.createEffect(PotionEffectType.SATURATION, PlayerManager.MAX_EFFECT_DURATION,
				PlayerManager.MAX_EFFECT_AMPLIFIER));
		effects.add(PlayerManager.createEffect(PotionEffectType.DAMAGE_RESISTANCE, PlayerManager.MAX_EFFECT_DURATION,
				PlayerManager.MAX_EFFECT_AMPLIFIER));
	}
}
