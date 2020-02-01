package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfigurationEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class HungerGameEditionsFactory extends AbstractConfigurationEditionsFactory<IHungerGameConfiguration> {

	public static HungerGameEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private HungerGameEditionsFactory(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final HungerGameEditionsFactory factory = new HungerGameEditionsFactory(
				PersistenceFactory.getInstance().getHungerGamePersistence());
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrentHungerGame(context);
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createGameTimeEdition() {
		return new GameTimeHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createLoadEdition() {
		return new LoadHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createListEdition() {
		return new ListHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createCurrentEdition() {
		return new CurrentHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createNewEdition() {
		return new NewHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createRenameEdition() {
		return new RenameHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createSaveEdition() {
		return new SaveHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createDeleteEdition() {
		return new DeleteHungerGame();
	}

	@Override
	public IMapEdition<IHungerGameConfiguration> createResetEdition() {
		return new ResetHungerGame();
	}

	public IMapEdition<IHungerGameConfiguration> createBorderCenterEdition() {
		return new BorderCenterHungerGame();
	}

	public IMapEdition<IHungerGameConfiguration> createInitialBorderDiameterEdition() {
		return new InitialBorderDiameterHungerGame();
	}

	public IMapEdition<IHungerGameConfiguration> createFinalBorderDiameterEdition() {
		return new FinalBorderDiameterHungerGame();
	}

	public IMapEdition<IHungerGameConfiguration> createSpeedBorderEdition() {
		return new BorderSpeedHungerGame();
	}

	public IMapEdition<IHungerGameConfiguration> createFractionTimeEdition() {
		return new FractionTimeHungerGame();
	}

	public IMapEdition<IHungerGameConfiguration> createWarningTimeEdition() {
		return new WarningTimeHungerGame();
	}

	public IMapEdition<IHungerGameConfiguration> createPvpTimeEdition() {
		return new PvpTimeHungerGame();
	}
}
