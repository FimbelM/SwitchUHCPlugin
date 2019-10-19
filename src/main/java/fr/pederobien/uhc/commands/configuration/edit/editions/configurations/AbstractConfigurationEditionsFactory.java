package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class AbstractConfigurationEditionsFactory<T extends IConfiguration> extends AbstractEditionsFactory<T> {

	public AbstractConfigurationEditionsFactory(IPersistence<T> persistence) {
		super(persistence);
	}

	public IMapEdition createScoreboardRefreshEdition() {
		return new CommonScoreboardRefresh<T>(persistence);
	}

	public abstract IMapEdition createAsCurrentEdition(IConfigurationContext context);

	public abstract IMapEdition createGameTimeEdition();

	public abstract IMapEdition createLoadEdition();
}
