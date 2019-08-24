package fr.pederobien.uhc.game;

import java.time.LocalTime;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Game implements IGame, IGameState {
	public static final Game DEFAULT;
	private IGameState initiate;
	private IGameState start;
	private IGameState playerRevive;
	private IGameState playerDontRevive;
	private IGameState hungerGame;
	private IGameState pause;
	private IGameState relaunched;
	private IGameState stop;
	private IGameState current;
	
	static {
		DEFAULT = new Game();
	}

	public Game() {
		initiate = new InitiateState(this);
		start = new StartState(this);
		playerRevive = new PlayerReviveState(this);
		playerDontRevive = new PlayerDontReviveState(this);
		hungerGame = new HungerGameState(this);
		pause = new PauseState(this);
		relaunched = new RelaunchedState(this);
		stop = new StopState(this);
		current = initiate;
	}
	
	@Override
	public IGameState getCurrentState() {
		return current;
	}

	@Override
	public void setCurrentState(IGameState current) {
		this.current = current;
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
	public IGameState getRelaunched() {
		return relaunched;
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
	public void pause() {
		current.pause();
	}

	@Override
	public void relaunched() {
		current.pause();
	}

	@Override
	public void stop() {
		current.stop();
	}

	@Override
	public void timeChanged(LocalTime time) {
		current.timeChanged(time);
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
}
