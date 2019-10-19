package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfigurationEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
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
	public IMapEdition createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrentHungerGame(persistence, context);
	}

	@Override
	public IMapEdition createGameTimeEdition() {
		return new GameTimeHungerGame(persistence);
	}

	@Override
	public IMapEdition createLoadEdition() {
		return new LoadHungerGame(persistence);
	}

	@Override
	public IMapEdition createListEdition() {
		return new ListHungerGame(persistence);
	}

	@Override
	public IMapEdition createCurrentEdition() {
		return new CurrentHungerGame(persistence);
	}

	@Override
	public IMapEdition createNewEdition() {
		return new NewHungerGame(persistence);
	}

	@Override
	public IMapEdition createRenameEdition() {
		return new RenameHungerGame(persistence);
	}

	@Override
	public IMapEdition createSaveEdition() {
		return new SaveHungerGame(persistence);
	}

	public IMapEdition createBorderCenterEdition() {
		return new BorderCenterHungerGame(persistence);
	}

	public IMapEdition createInitialBorderDiameterEdition() {
		return new InitialBorderDiameterHungerGame(persistence);
	}

	public IMapEdition createFinalBorderDiameterEdition() {
		return new FinalBorderDiameterHungerGame(persistence);
	}

	public IMapEdition createFractionTimeEdition() {
		return new FractionTimeHungerGame(persistence);
	}
}
