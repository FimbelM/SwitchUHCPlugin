package fr.pederobien.uhc.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.game.Game;

public abstract class AbstractGameCommand extends AbstractCommand {
	protected static Game game;

	public AbstractGameCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
		game = new Game(configuration, listener);
	}
}
