package fr.pederobien.uhc.game.hungergame;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.game.AbstractGame;
import fr.pederobien.uhc.world.EventListener;

public class HungerGame extends AbstractGame<IHungerGameState> implements IHungerGame {
	private IHungerGameState initiate;
	private IHungerGameState start;
	private IHungerGameState playerRevive;
	private IHungerGameState playerDontRevive;
	private IHungerGameState hungerGame;
	private IHungerGameState pause;
	private IHungerGameState stop;
	private IHungerGameState current;
	private HungerGameConfiguration configuration;
	private EventListener listener;

	public HungerGame(HungerGameConfiguration configuration, EventListener listener) {
		this.configuration = configuration;
		this.listener = listener;
		
		initiate = new InitialState(this);
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
	public IHungerGameState getCurrentState() {
		return current;
	}

	@Override
	public IHungerGameState setCurrentState(IHungerGameState current) {
		return this.current = current;
	}

	@Override
	public IHungerGameState getInitiate() {
		return initiate;
	}

	@Override
	public IHungerGameState getStart() {
		return start;
	}

	@Override
	public IHungerGameState getPlayerRevive() {
		return playerRevive;
	}

	@Override
	public IHungerGameState getPlayerDontRevive() {
		return playerDontRevive;
	}

	@Override
	public IHungerGameState getHungerGame() {
		return hungerGame;
	}

	@Override
	public IHungerGameState getPause() {
		return pause;
	}

	@Override
	public IHungerGameState getStop() {
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
	public void pause(IHungerGameState before) {
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
	public HungerGameConfiguration getConfiguration() {
		return configuration;
	}
	
	@Override
	public EventListener getEventListener() {
		return listener;
	}
}
