package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class HungerGameEditionsFactory {
	private IPersistence<IHungerGameConfiguration> persistence = ConfigurationsFactory.getInstance().getHungerGamePersistence();

	public static HungerGameEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final HungerGameEditionsFactory factory = new HungerGameEditionsFactory();
	}

	public IEdition createBorderCenterEdition() {
		return new BorderCenterEdition(persistence);
	}

	public IEdition createInitialBorderDiameterEdition() {
		return new InitialBorderDiameter(persistence);
	}

	public IEdition createFinalBorderDiameterEdition() {
		return new FinalBorderDiameter(persistence);
	}

	public IEdition createGameTimeEdition() {
		return new GameTime(persistence);
	}

	public IEdition createFractionTimeEdition() {
		return new FractionTime(persistence);
	}

	public IEdition createScoreboardRefreshEdition() {
		return new ScoreboardRefresh(persistence);
	}

	public IEdition createRenameEdition() {
		return new Rename(persistence);
	}

	public IEdition createLoadEdition() {
		return new Load(persistence);
	}

	public IEdition createNewConfEdition() {
		return new NewConf(persistence);
	}

	public IEdition createCurrentEdition() {
		return new Current(persistence);
	}

	public IEdition createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrent(persistence, context);
	}

	public IEdition createSaveEdition() {
		return new Save(persistence);
	}

	public IEdition createListEdition() {
		return new ListConf(persistence);
	}

	public IEdition createHelpEdition() {
		return new Help(persistence);
	}
}
