package fr.pederobien.uhc.managers;

import java.util.HashMap;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class BlockedexPlayerManager extends PlayerManager {
	private HashMap<Player, Restriction> map;

	public BlockedexPlayerManager() {
		map = new HashMap<Player, Restriction>();
		for (Player player : PlayerManager.getPlayers())
			map.put(player, new Restriction(player));
	}
	
	public void decreaseMaxHealth(Player player, double decrease) {
		map.get(player).decreaseMaxHealth(decrease);
	}
	
	public void increaseMaxHealth(Player player, double increase) {
		map.get(player).increaseMaxHealth(increase);
	}

	private class Restriction {
		private Player player;
		
		public Restriction(Player player) {
			this.player = player;
		}

		public double getMaxHealth() {
			return player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
		}

		public void setMaxHealth(double maxHealth) {
			setMaxHealthOfPlayer(player, maxHealth);
		}
		
		public void increaseMaxHealth(double increase) {
			setMaxHealth(getMaxHealth() + increase);
		}
		
		public void decreaseMaxHealth(double decrease) {
			setMaxHealth(getMaxHealth() - decrease);
		}
	}
}
