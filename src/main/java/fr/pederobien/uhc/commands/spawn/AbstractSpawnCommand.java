package fr.pederobien.uhc.commands.spawn;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.conf.Spawn;

public abstract class AbstractSpawnCommand extends AbstractCommand {
	protected static Spawn spawn;
	
	public AbstractSpawnCommand() {
		spawn = new Spawn();
	}
}
