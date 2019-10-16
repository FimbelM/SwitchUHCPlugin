package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfigurationEditionsFactory;
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class HungerGameEditionsFactory extends AbstractConfigurationEditionsFactory<IHungerGameConfiguration> {

	public static HungerGameEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private HungerGameEditionsFactory(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final HungerGameEditionsFactory factory = new HungerGameEditionsFactory(
				ConfigurationsFactory.getInstance().getHungerGamePersistence());
	}

	@Override
	public IEdition createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrentHungerGame(persistence, context);
	}

	@Override
	public IEdition createGameTimeEdition() {
		return new GameTimeHungerGame(persistence);
	}

	@Override
	public IEdition createLoadEdition() {
		return new LoadHungerGame(persistence);
	}

	@Override
	public IEdition createListEdition() {
		return new ListHungerGame(persistence);
	}

	@Override
	public IEdition createCurrentEdition() {
		return new CurrentHungerGame(persistence);
	}

	@Override
	public IEdition createNewEdition() {
		return new NewHungerGame(persistence);
	}

	@Override
	public IEdition createRenameEdition() {
		return new RenameHungerGame(persistence);
	}
	
	@Override
	public IEdition createSaveEdition() {
		return new SaveHungerGame(persistence);
	}

	public IEdition createBorderCenterEdition() {
		return new BorderCenterHungerGame(persistence);
	}
	
	public IEdition createInitialBorderDiameterEdition() {
		return new InitialBorderDiameterHungerGame(persistence);
	}
	
	public IEdition createFinalBorderDiameterEdition() {
		return new FinalBorderDiameterHungerGame(persistence);
	}
	
	public IEdition createFractionTimeEdition() {
		return new FractionTimeHungerGame(persistence);
	}
}
