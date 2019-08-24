package fr.pederobien.uhc.commands.game;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.game.Game;

public abstract class AbstractGameCommand extends AbstractCommand {
	protected static Game game;
	
	public AbstractGameCommand() {
		game = new Game(configuration);
	}
}
