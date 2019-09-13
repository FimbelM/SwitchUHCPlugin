package fr.pederobien.uhc.observer;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public interface IObsListener {
	
	default void onPlayerJoin(PlayerJoinEvent event) {}
	
	default void onPlayerDie(PlayerDeathEvent event) {}
	
	default void onPlayerQuit(PlayerQuitEvent event) {}
	
	default void onPlayerRespawn(PlayerRespawnEvent event) {}

	default void onPlayerMove(PlayerMoveEvent event) {}
}
