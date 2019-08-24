package fr.pederobien.uhc;

import org.bukkit.plugin.java.JavaPlugin;

public class UHCPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("UHC plugin enable");
	}

	@Override
	public void onDisable() {
		getLogger().info("UHC plugin disable");
	}
}
