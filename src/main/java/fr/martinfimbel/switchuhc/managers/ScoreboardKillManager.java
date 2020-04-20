package fr.martinfimbel.switchuhc.managers;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class ScoreboardKillManager {
	private static Map<Player, Integer> killcount = new HashMap<Player, Integer>();

	public static void increase(Player player) {
		int oldkill = 0;
		if (killcount.get(player) == null) {
			oldkill = 0;
		} else {
			oldkill = killcount.get(player);
		}
		int newkill = oldkill + 1;
		killcount.put(player, newkill);
	}

	public static Integer getkill(Player player) {
		Integer kills = killcount.get(player);
		return kills == null ? 0 : kills;
	}
}
