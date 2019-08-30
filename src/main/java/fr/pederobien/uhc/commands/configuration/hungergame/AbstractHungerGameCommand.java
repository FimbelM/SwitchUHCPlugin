package fr.pederobien.uhc.commands.configuration.hungergame;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public abstract class AbstractHungerGameCommand extends AbstractCommand {
	protected HungerGamePersistence hungergamePersistence = new HungerGamePersistence();

	public AbstractHungerGameCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
	
	protected HungerGameConfiguration getConfiguration() {
		return hungergamePersistence.get();
	}
}
