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
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
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
	protected IPersistence<IBlockedexConfiguration> getPersistenceImpl() {
		return new BlockedexPersistence();
	}

	@Override
	protected void setEditions() {
		gameTime = new GameTime(getPersistence());
		scoreboardRefresh = new ScoreboardRefresh(getPersistence());
		rename = new Rename(getPersistence());
		load = new Load(getPersistence());
		newConf = new NewConf(getPersistence());
		current = new Current(getPersistence());
		asCurrent = new AsCurrent(getPersistence(), context);
		save = new Save(getPersistence());
		list = new ListConf(getPersistence());
		help = new Help(getPersistence());

		addToMap(gameTime, scoreboardRefresh, rename, load, newConf, current, asCurrent, save, list, help);
	}
}
