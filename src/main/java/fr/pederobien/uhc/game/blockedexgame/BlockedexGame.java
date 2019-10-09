package fr.pederobien.uhc.game.blockedexgame;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.conf.configurations.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.pederobien.uhc.game.AbstractGame;

public class BlockedexGame extends AbstractGame implements IBlockedexGame {
	private IBlockedexGameState initiate;
	private IBlockedexGameState started;
	private IBlockedexGameState start;
	private IBlockedexGameState stop;
	private IBlockedexGameState current;
	private IUnmodifiableBlockedexConfiguration configuration;

	public BlockedexGame(IUnmodifiableBlockedexConfiguration configuration) {
		this.configuration = configuration;

		initiate = new InitialState(this);
		started = new StartedState(this);
		start = new StartState(this);
		stop = new StopState(this);
		current = initiate;
	}

	@Override
	public IBlockedexGameState getCurrentState() {
		return current;
	}

	@Override
	public IBlockedexGameState setCurrentState(IBlockedexGameState current) {
		return this.current = current;
	}

	@Override
	public IBlockedexGameState getInitiate() {
		return initiate;
	}

	@Override
	public IBlockedexGameState getStarted() {
		return started;
	}

	@Override
	public IBlockedexGameState getStart() {
		return start;
	}

	@Override
	public IBlockedexGameState getStop() {
		return stop;
	}

	@Override
	public IUnmodifiableBlockedexConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public void initiate() {
		current.initiate();
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
	public void onPlayerQuit(PlayerQuitEvent event) {
		current.onPlayerQuit(event);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		current.onPlayerRespawn(event);
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		current.onPlayerMove(event);
	}

	@Override
	public void time() {
		current.time();
	}
}
