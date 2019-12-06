package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class AbstractConfigurationEditionsFactory<T extends IConfiguration> extends AbstractEditionsFactory<T> {

	public AbstractConfigurationEditionsFactory(IPersistence<T> persistence) {
		super(persistence);
	}

	public IMapEdition<T> createScoreboardRefreshEdition() {
		return new CommonScoreboardRefresh<T>();
	}

	public IMapEdition<T> createTeamEdition() {
		return new CommonTeam<T>();
	}

	public abstract IMapEdition<T> createAsCurrentEdition(IConfigurationContext context);

	public abstract IMapEdition<T> createGameTimeEdition();

	public abstract IMapEdition<T> createLoadEdition();
}
