package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfigurationEditionsFactory;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;
import fr.martinfimbel.switchuhc.persistence.PersistenceFactory;

public class SwitchGameEditionsFactory extends AbstractConfigurationEditionsFactory<ISwitchGameConfiguration>{

	public static SwitchGameEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private SwitchGameEditionsFactory(IPersistence<ISwitchGameConfiguration> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final SwitchGameEditionsFactory factory = new SwitchGameEditionsFactory(
				PersistenceFactory.getInstance().getSwitchPersistence());
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrentSwitchGame(context);
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createGameTimeEdition() {
		return new MovingBorderTimeSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createLoadEdition() {
		return new LoadSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createListEdition() {
		return new ListSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createCurrentEdition() {
		return new CurrentSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createNewEdition() {
		return new NewSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createRenameEdition() {
		return new RenameSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createSaveEdition() {
		return new SaveSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createDeleteEdition() {
		return new DeleteSwitchGame();
	}

	@Override
	public IMapEdition<ISwitchGameConfiguration> createResetEdition() {
		return new ResetSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createBorderCenterEdition() {
		return new BorderCenterSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createInitialBorderDiameterEdition() {
		return new InitialBorderDiameterSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createFinalBorderDiameterEdition() {
		return new FinalBorderDiameterSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createSpeedBorderEdition() {
		return new BorderSpeedSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createFractionTimeEdition() {
		return new PlayerDontReviveTimeSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createWarningTimeEdition() {
		return new WarningTimeSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createPvpTimeEdition() {
		return new PvpTimeSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createStartSwitchTimeEdition() {
		return new StartSwitchTimeSwitchGame();
	}

	public IMapEdition<ISwitchGameConfiguration> createSwitchTimeEdititon() {
		return new SwitchTimeSwitchGame();
	}
	
	public IMapEdition<ISwitchGameConfiguration> createNumberOfPlayerSwitchableEdition() {
		return new NumberOfPlayerSwitchable();
	}
	
	public IMapEdition<ISwitchGameConfiguration> createSwitchAfterBorderMovesEdition() {
		return new SwitchAfterBorderMoves();
	}
	
	public IMapEdition<ISwitchGameConfiguration> createReviveNearTeamateEdition() {
		return new ReviveNearTeamate();
	}
	
	public IMapEdition<ISwitchGameConfiguration> createOnePlayerSwitchEdition() {
		return new OnePlayerSwitch();
	}
	
}
