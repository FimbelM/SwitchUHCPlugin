package fr.pederobien.uhc.configurations;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.observers.IObsGame;

public class ConfigurationContext implements IConfigurationContext {
	private IConfiguration configuration;

	@Override
	public void setCurrentConfiguration(IConfiguration configuration) {
		if (this.configuration != null)
			getGame().removeObserver(PluginDeposit.plugin);
		this.configuration = configuration;
		getGame().addObserver(PluginDeposit.plugin);
	}

	@Override
	public IConfiguration getCurrentConfiguration() {
		return configuration;
	}

	@Override
	public boolean initiate() {
		return getGame().initiate();
	}

	@Override
	public void start() {
		getGame().start();
	}

	@Override
	public void stop() {
		getGame().stop();
	}

	@Override
	public void pause() {
		getGame().pause();
	}

	@Override
	public void relaunch() {
		getGame().relaunch();
	}

	@Override
	public MessageCode getMessage() {
		return getGame().getMessage();
	}

	@Override
	public void addObserver(IObsGame obs) {
		getGame().addObserver(obs);
	}

	@Override
	public void removeObserver(IObsGame obs) {
		getGame().removeObserver(obs);
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		getGame().onPlayerJoin(event);
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		getGame().onPlayerDie(event);
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		getGame().onPlayerQuit(event);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		getGame().onPlayerRespawn(event);
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		getGame().onPlayerMove(event);
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		getGame().onPlayerInteract(event);
	}

	@Override
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		getGame().onCreatureSpawn(event);
	}

	@Override
	public void onPlayerPortalEvent(PlayerPortalEvent event) {
		getGame().onPlayerPortalEvent(event);
	}

	@Override
	public IGame getGame() {
		return configuration.getGame();
	}

	@Override
	public String getName() {
		return configuration.getName();
	}

	@Override
	public void setName(String name) {
		configuration.setName(name);
	}

	@Override
	public List<EColor> getTeams() {
		return configuration.getTeams();
	}

	@Override
	public boolean addTeam(EColor team) {
		return configuration.addTeam(team);
	}

	@Override
	public void removeTeam(EColor team) {
		configuration.removeTeam(team);
	}

	@Override
	public Long getScoreboardRefresh() {
		return configuration.getScoreboardRefresh();
	}

	@Override
	public void setScoreboardRefresh(Long refresh) {
		configuration.setScoreboardRefresh(refresh);
	}

	@Override
	public LocalTime getGameTime() {
		return configuration.getGameTime();
	}

	@Override
	public void setGameTime(LocalTime gameTime) {
		configuration.setGameTime(gameTime);
	}

	@Override
	public Stream<String> getPlayersRegistered() {
		return configuration.getPlayersRegistered();
	}
}
