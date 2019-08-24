package fr.pederobien.uhc.game;

import java.time.LocalTime;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class StopState extends AbstractState {

	public StopState(IGame game) {
		super(game);
	}

	@Override
	public void timeChanged(LocalTime time) {

	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {

	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {

	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {

	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {

	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {

	}

	@Override
	public void run() {

	}
}
