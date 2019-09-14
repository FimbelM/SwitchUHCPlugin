package fr.pederobien.uhc.observer;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public interface IObsListener {
	
	void onPlayerJoin(PlayerJoinEvent event);
	
	void onPlayerDie(PlayerDeathEvent event);
	
	void onPlayerQuit(PlayerQuitEvent event);
	
	void onPlayerRespawn(PlayerRespawnEvent event);

	void onPlayerMove(PlayerMoveEvent event);
}
