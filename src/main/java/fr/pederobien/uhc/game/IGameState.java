package fr.pederobien.uhc.game;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.utils.Function;

public interface IGameState extends IObsListener, Function {

	void initiate();

	void start();

	void pause(IGameState before);

	void relaunched();

	void stop();

	void onPlayerDie(PlayerDeathEvent event);

	void onPlayerJoin(PlayerJoinEvent event);

	void onPlayerMove(PlayerMoveEvent event);

	void onPlayerQuit(PlayerQuitEvent event);

	void onPlayerRespawn(PlayerRespawnEvent event);

	void run();
}
