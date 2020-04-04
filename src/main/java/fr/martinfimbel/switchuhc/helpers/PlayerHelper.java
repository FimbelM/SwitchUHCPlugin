package fr.martinfimbel.switchuhc.helpers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBorderConfiguration;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class PlayerHelper {
	private static IUnmodifiableBorderConfiguration configuration;

	public static Location getPlayerLocationRelativeToBorderCenter(Player player) {
		if (configuration == null)
			return player.getLocation();
		Location playerloc = player.getLocation(), centerLocation = configuration.getBorderCenter().getLocation();
				int netherCenterLocationX = centerLocation.getBlockX()/8;
				int netherCenterLocationZ = centerLocation.getBlockZ()/8;
		if (player.getWorld() == WorldManager.SURFACE_WORLD) {
			Location locationToBorderCenter = new Location(player.getWorld(),
					playerloc.getBlockX() - centerLocation.getBlockX(), playerloc.getBlockY(),
					(playerloc.getBlockZ() - centerLocation.getBlockZ()));
			return locationToBorderCenter;
		} else {
			Location locationToBorderCenter = new Location(player.getWorld(), playerloc.getBlockX() - netherCenterLocationX, playerloc.getBlockY(),
					(playerloc.getBlockZ() - netherCenterLocationZ));
			return locationToBorderCenter;
		}
	}

	public static void setCurrentConfiguration(IUnmodifiableBorderConfiguration configuration) {
		PlayerHelper.configuration = configuration;
	}
}
