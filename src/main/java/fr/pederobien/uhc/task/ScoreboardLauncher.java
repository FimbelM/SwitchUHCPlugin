package fr.pederobien.uhc.task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.observer.IObsTimeLine;
import fr.pederobien.uhc.scoreboard.hungergame.IScoreboard;
import fr.pederobien.uhc.scoreboard.hungergame.Scoreboard;

public class ScoreboardLauncher extends BukkitRunnable implements IObsTimeLine, IObsListener {
	private List<IScoreboard> scoreboards;
	private TimeTask task;

	public ScoreboardLauncher(TimeTask task) {
		this.task = task;
		scoreboards = new ArrayList<IScoreboard>();
		for (Player player : PlayerManager.getPlayers())
			scoreboards.add(new Scoreboard(player, task));
	}

	@Override
	public void run() {
		for (IScoreboard sc : scoreboards)
			sc.update();
	}

	@Override
	public synchronized void cancel() throws IllegalStateException {
		super.cancel();
		for (IScoreboard sc : scoreboards)
			sc.stop();
	}

	public void start() {
		for (IScoreboard sc : scoreboards)
			sc.start();
	}

	public void pause() {
		for (IScoreboard sc : scoreboards)
			sc.pause(sc.getCurrentState());
	}

	public void relaunched() {
		for (IScoreboard sc : scoreboards)
			sc.relaunched();
	}
	
	@Override
	public void time() {
		for (IScoreboard sc : scoreboards)
			sc.time();
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		try {
			scoreboards.add(new Scoreboard(event.getPlayer(), task));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		scoreboards.removeIf(new Predicate<IScoreboard>() {

			@Override
			public boolean test(IScoreboard t) {
				return t.getPlayer().equals(event.getPlayer());
			}
		});
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		
	}
}
