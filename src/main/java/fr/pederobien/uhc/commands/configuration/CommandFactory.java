package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.game.PauseCommand;
import fr.pederobien.uhc.commands.game.StartCommand;
import fr.pederobien.uhc.commands.game.StopCommand;
import fr.pederobien.uhc.interfaces.ICommand;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class CommandFactory {
	private static ICommand startCommand;
	private static ICommand pauseCommand;
	private static ICommand stopCommand;
	private static ICommand baseConfigurationCommand;
	private static ICommand spawnConfigurationCommand;
	private static ICommand blockedexConfigurationCommand;
	private static ICommand hungerGameConfigurationCommand;

	public static ICommand getStartCommand() {
		return startCommand;
	}

	public static ICommand getStopCommand() {
		return stopCommand;
	}

	public static ICommand getPauseCommand() {
		return pauseCommand;
	}

	public static ICommand getBaseConfigurationCommand() {
		return baseConfigurationCommand;
	}

	public static ICommand getSpawnConfigurationCommand() {
		return spawnConfigurationCommand;
	}

	public static ICommand getBlockedexConfigurationCommand() {
		return blockedexConfigurationCommand;
	}

	public static ICommand getHungerGameConfigurationCommand() {
		return hungerGameConfigurationCommand;
	}

	public static void initiate(JavaPlugin plugin, IConfigurationContext context) {
		AbstractCommand.setConfigurationContext(context);

		startCommand = new StartCommand(plugin, "startgame");
		stopCommand = new StopCommand(plugin, "stopgame");
		pauseCommand = new PauseCommand(plugin, "pausegame");
		baseConfigurationCommand = new BaseConfigurationCommand(plugin, "base");
		spawnConfigurationCommand = new SpawnConfigurationCommand(plugin, "spawn");
		blockedexConfigurationCommand = new BlockedexConfigurationCommand(plugin, "bd");
		hungerGameConfigurationCommand = new HungerGameConfigurationCommand(plugin, "hg");
	}
}
