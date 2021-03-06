package fr.martinfimbel.switchuhc.game.switching;

import java.time.LocalTime;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.game.AbstractGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableSwitchConfiguration;

public class SwitchGame extends AbstractGame implements ISwitchGame {
	private ISwitchGameState initiate;
	private ISwitchGameState start;
	private ISwitchGameState playerRevive;
	private ISwitchGameState playerDontRevive;
	private ISwitchGameState movingBorder;
	private ISwitchGameState stop;
	private ISwitchGameState current;

	private LocalTime nextSwitchTime, decreasingSwitchTime;
	private IUnmodifiableSwitchConfiguration configuration;
	private boolean firstSwitch;

	public SwitchGame(IUnmodifiableSwitchConfiguration configuration) {
		this.configuration = configuration;
		initiate = new InitialState(this);
		start = new StartState(this);
		playerRevive = new PlayerReviveState(this);
		playerDontRevive = new PlayerDontReviveState(this);
		movingBorder = new BorderMovingState(this);
		stop = new StopState(this);
		current = initiate;

		firstSwitch = false;
	}

	@Override
	public ISwitchGameState getCurrentState() {
		return current;
	}

	@Override
	public ISwitchGameState setCurrentState(ISwitchGameState current) {
		return this.current = current;
	}

	@Override
	public ISwitchGameState getInitiate() {
		return initiate;
	}

	@Override
	public ISwitchGameState getStart() {
		return start;
	}

	@Override
	public ISwitchGameState getPlayerRevive() {
		return playerRevive;
	}

	@Override
	public ISwitchGameState getPlayerDontRevive() {
		return playerDontRevive;
	}

	@Override
	public ISwitchGameState getSwitchGame() {
		return movingBorder;
	}

	@Override
	public ISwitchGameState getStop() {
		return stop;
	}

	@Override
	public boolean initiate() {
		return current.initiate();
	}

	@Override
	public void start() {
		super.start();
		current.start();
	}

	@Override
	public void pause() {
		current.pause();
	}

	@Override
	public void relaunch() {
		current.relaunch();
	}

	@Override
	public void stop() {
		super.stop();
		current.stop();
		firstSwitch = false;
	}

	@Override
	public MessageCode getMessage() {
		return current.getMessage();
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		super.onPlayerDie(event);
		current.onPlayerDie(event);
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		current.onPlayerJoin(event);
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		current.onPlayerMove(event);
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		current.onPlayerQuit(event);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		current.onPlayerRespawn(event);
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		current.onPlayerInteract(event);
	}

	@Override
	public void onPlayerInventoryClick(InventoryClickEvent event) {
		current.onPlayerInventoryClick(event);
	}

	@Override
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		current.onCreatureSpawn(event);
	}

	@Override
	public void onPlayerPortalEvent(PlayerPortalEvent event) {
		current.onPlayerPortalEvent(event);
	}

	@Override
	public void time(LocalTime time) {
		current.time(time);
	}

	@Override
	public IUnmodifiableSwitchConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public LocalTime getPeriod() {
		return getConfiguration().getPeriodSwitchTime();
	}

	@Override
	public void setNextSwitchTime(LocalTime time) {
		this.nextSwitchTime = time;
		if (firstSwitch)
			decreasingSwitchTime = getConfiguration().getPeriodSwitchTime();
		else {
			decreasingSwitchTime = getConfiguration().getStartSwitchTime();
			firstSwitch = true;
		}
	}

	@Override
	public LocalTime getNextSwitchTime() {
		return firstSwitch ? nextSwitchTime : getConfiguration().getStartSwitchTime();
	}

	@Override
	public void notifyMinusOne() {
		decreasingSwitchTime = decreasingSwitchTime == null ? getConfiguration().getStartSwitchTime()
				: decreasingSwitchTime.minusSeconds(1);
	}

	@Override
	public LocalTime getDecreasingSwitchTime() {
		return decreasingSwitchTime;
	}

}
