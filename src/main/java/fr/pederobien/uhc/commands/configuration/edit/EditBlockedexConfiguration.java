package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.AsCurrent;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.Current;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.GameTime;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.Help;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.ListConf;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.Load;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.NewConf;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.Rename;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.Save;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.ScoreboardRefresh;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;

public class EditBlockedexConfiguration extends AbstractEditConfiguration {
	private BlockedexPersistence persistence;

	private IEdition gameTime;
	private IEdition scoreboardRefresh;
	private IEdition rename;
	private IEdition load;
	private IEdition newConf;
	private IEdition current;
	private IEdition asCurrent;
	private IEdition save;
	private IEdition list;
	private IEdition help;

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected void setEditions() {
		persistence = new BlockedexPersistence();
		
		gameTime = new GameTime(persistence);
		scoreboardRefresh = new ScoreboardRefresh(persistence);
		rename = new Rename(persistence);
		load = new Load(persistence);
		newConf = new NewConf(persistence);
		current = new Current(persistence);
		asCurrent = new AsCurrent(persistence, context);
		save = new Save(persistence);
		list = new ListConf(persistence);
		help = new Help(persistence);

		addToMap(gameTime, scoreboardRefresh, rename, load, newConf, current, asCurrent, save, list, help);
	}
}
