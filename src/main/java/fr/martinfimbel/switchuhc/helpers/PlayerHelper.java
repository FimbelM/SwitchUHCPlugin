package fr.martinfimbel.switchuhc.helpers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBorderConfiguration;

public class PlayerHelper {
	private static IUnmodifiableBorderConfiguration configuration;

	public static Location getPlayerLocationRelativeToBorderCenter(Player player) {
		if(configuration == null)
			return player.getLocation();
		Location playerloc = player.getLocation(), centerLocation = configuration.getBorderCenter().getLocation();
		Location locationToBorderCenter = new Location(player.getWorld(),
				playerloc.getBlockX() - centerLocation.getBlockX(), playerloc.getBlockY(),
				(playerloc.getBlockZ() - centerLocation.getBlockZ()));
		return locationToBorderCenter;
	}

	public static void setCurrentConfiguration(IUnmodifiableBorderConfiguration configuration) {
		PlayerHelper.configuration = configuration;
	}
}
