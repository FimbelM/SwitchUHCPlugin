package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;

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
