package fr.martinfimbel.switchuhc.environment;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.interfaces.IPlayer;
import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.managers.EColor;

public class UHCPlayer implements IPlayer {
	private static Map<String, IPlayer> players = new HashMap<String, IPlayer>();
	private EColor color;

	public static void register(Player player) {
		IPlayer uhcPlayer = players.get(player.getName());
		if (uhcPlayer != null) {
			player.setDisplayName(uhcPlayer.getColor().getInColor(player.getName()));
			ITeam playersTeam = UHCTeam.getTeam(player);

			if (playersTeam != null) {
				playersTeam.removePlayer(player);
				playersTeam.addPlayer(player);
			}
			return;
		}

		players.put(player.getName(), new UHCPlayer());
	}

	public static IPlayer get(Player player) {
		return players.get(player.getName());
	}

	@Override
	public EColor getColor() {
		return color == null ? EColor.RESET : color;
	}

	@Override
	public void setColor(EColor color) {
		this.color = color;
	}
}
