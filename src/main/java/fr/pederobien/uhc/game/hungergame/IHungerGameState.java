package fr.pederobien.uhc.game.hungergame;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.game.IGameBase;
import fr.pederobien.uhc.game.IGameBaseState;
import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.utils.Function;

public interface IHungerGameState extends IGameBase<IHungerGameState>, IGameBaseState, IObsListener, Function {

	void initiate();

	void onPlayerDie(PlayerDeathEvent event);

	void onPlayerJoin(PlayerJoinEvent event);

	void onPlayerMove(PlayerMoveEvent event);

	void onPlayerQuit(PlayerQuitEvent event);

	void onPlayerRespawn(PlayerRespawnEvent event);

	void run();
}
