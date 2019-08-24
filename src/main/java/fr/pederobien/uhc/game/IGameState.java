package fr.pederobien.uhc.game;

import java.time.LocalTime;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.observer.IObsTimeTask;
import fr.pederobien.utils.Function;

public interface IGameState extends IObsListener, IObsTimeTask, Function {

	void initiate();

	void start();

	void pause();

	void relaunched();

	void stop();

	void timeChanged(LocalTime time);

	void onPlayerDie(PlayerDeathEvent event);

	void onPlayerJoin(PlayerJoinEvent event);

	void onPlayerMove(PlayerMoveEvent event);

	void onPlayerQuit(PlayerQuitEvent event);

	void onPlayerRespawn(PlayerRespawnEvent event);
	
	void run();
}
