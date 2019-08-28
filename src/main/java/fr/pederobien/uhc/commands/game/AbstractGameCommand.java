package fr.pederobien.uhc.commands.game;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;

public abstract class AbstractGameCommand extends AbstractCommand {

	public AbstractGameCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
}
