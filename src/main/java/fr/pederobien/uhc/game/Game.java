package fr.pederobien.uhc.game;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.conf.Configuration;
import fr.pederobien.uhc.world.EventListener;

public class Game implements IGame {
	private IGameState initiate;
	private IGameState start;
	private IGameState playerRevive;
	private IGameState playerDontRevive;
	private IGameState hungerGame;
	private IGameState pause;
	private IGameState stop;
	private IGameState current;
	private Configuration configuration;
	private EventListener listener;

	public Game(Configuration configuration, EventListener listener) {
		this.configuration = configuration;
		this.listener = listener;
		
		initiate = new InitiateState(this);
		start = new StartState(this);
		playerRevive = new PlayerReviveState(this);
		playerDontRevive = new PlayerDontReviveState(this);
		hungerGame = new HungerGameState(this);
		pause = new PauseState(this);
		stop = new StopState(this);
		current = initiate;
		
		initiate();
	}
	
	@Override
	public IGameState getCurrentState() {
		return current;
	}

	@Override
	public IGameState setCurrentState(IGameState current) {
		return this.current = current;
	}

	@Override
	public IGameState getInitiate() {
		return initiate;
	}

	@Override
	public IGameState getStart() {
		return start;
	}

	@Override
	public IGameState getPlayerRevive() {
		return playerRevive;
	}

	@Override
	public IGameState getPlayerDontRevive() {
		return playerDontRevive;
	}

	@Override
	public IGameState getHungerGame() {
		return hungerGame;
	}

	@Override
	public IGameState getPause() {
		return pause;
	}

	@Override
	public IGameState getStop() {
		return stop;
	}

	@Override
	public void initiate() {
		current.initiate();
	}

	@Override
	public void start() {
		current.start();
	}

	@Override
	public void pause(IGameState before) {
		current.pause(before);
	}

	@Override
	public void relaunched() {
		current.relaunched();
	}

	@Override
	public void stop() {
		current.stop();
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
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
	public void run() {
		current.run();
	}

	@Override
	public Configuration getConfiguration() {
		return configuration;
	}
	
	@Override
	public EventListener getEventListener() {
		return listener;
	}
}
