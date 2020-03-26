package fr.martinfimbel.switchuhc.configurations;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.martinfimbel.switchuhc.PluginDeposit;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.game.IGame;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.observers.IObsGame;

public class ConfigurationContext implements IConfigurationContext {
	private IConfiguration configuration;

	@Override
	public void setCurrentConfiguration(IConfiguration configuration) {
		if (getCurrentConfiguration() != null)
			getGame().removeObserver(PluginDeposit.plugin);
		this.configuration = configuration;
		TeamsManager.setCurrentConfiguration(getCurrentConfiguration());
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
	public void onPlayerInventoryClick(InventoryClickEvent event) {
		getGame().onPlayerInventoryClick(event);
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
		return getCurrentConfiguration().getGame();
	}

	@Override
	public String getName() {
		return getCurrentConfiguration().getName();
	}

	@Override
	public void setName(String name) {
		getCurrentConfiguration().setName(name);
	}

	@Override
	public List<ITeam> getTeams() {
		return getCurrentConfiguration().getTeams();
	}

	@Override
	public List<ITeam> getNotEmptyTeams() {
		return getCurrentConfiguration().getNotEmptyTeams();
	}

	@Override
	public String showTeams() {
		return getCurrentConfiguration().showTeams();
	}

	@Override
	public ITeam getTeamByName(String name) {
		return getCurrentConfiguration().getTeamByName(name);
	}

	@Override
	public void addTeam(ITeam team) {
		getCurrentConfiguration().addTeam(team);
	}

	@Override
	public void removeTeam(ITeam team) {
		getCurrentConfiguration().removeTeam(team);
	}

	@Override
	public Long getScoreboardRefresh() {
		return getCurrentConfiguration().getScoreboardRefresh();
	}

	@Override
	public void setScoreboardRefresh(Long refresh) {
		getCurrentConfiguration().setScoreboardRefresh(refresh);
	}

	@Override
	public LocalTime getGameTime() {
		return getCurrentConfiguration().getGameTime();
	}

	@Override
	public void setGameTime(LocalTime gameTime) {
		getCurrentConfiguration().setGameTime(gameTime);
	}

	@Override
	public void reset() {
		getCurrentConfiguration().reset();
	}

	@Override
	public Stream<String> getPlayersRegistered() {
		return getCurrentConfiguration().getPlayersRegistered();
	}

	@Override
	public void prepareTeam() {
		getCurrentConfiguration().prepareTeam();
	}
}
