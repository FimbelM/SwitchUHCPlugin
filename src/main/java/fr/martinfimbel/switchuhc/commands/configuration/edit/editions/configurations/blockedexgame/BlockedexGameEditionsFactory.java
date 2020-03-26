package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfigurationEditionsFactory;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;
import fr.martinfimbel.switchuhc.persistence.PersistenceFactory;

public class BlockedexGameEditionsFactory extends AbstractConfigurationEditionsFactory<IBlockedexConfiguration> {

	public static BlockedexGameEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private BlockedexGameEditionsFactory(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final BlockedexGameEditionsFactory factory = new BlockedexGameEditionsFactory(
				PersistenceFactory.getInstance().getBlockedexPersistence());
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrentBlockedexGame(context);
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createGameTimeEdition() {
		return new GameTimeBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createLoadEdition() {
		return new LoadBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createListEdition() {
		return new ListeBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createCurrentEdition() {
		return new CurrentBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createNewEdition() {
		return new NewBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createRenameEdition() {
		return new RenameBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createSaveEdition() {
		return new SaveBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createDeleteEdition() {
		return new DeleteBlockedexGame();
	}

	@Override
	public IMapEdition<IBlockedexConfiguration> createResetEdition() {
		return new ResetBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createBasesEdition() {
		return new CommonBase();
	}

	public IMapEdition<IBlockedexConfiguration> createBaseDistanceEdition() {
		return new BaseDistanceBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createRadiusAreaOnPlayerDieEdition() {
		return new RadiusAreaOnPlayerDieBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createRadiusAreaOnPlayerKillEdition() {
		return new RadiusAreaOnPlayerKillBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createStepHealthEdition() {
		return new StepHealthBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createDiameterOnPlayerRespawnEdition() {
		return new DiameterOnPlayerRespawnBlockedexGame();
	}
}
