package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.AbstractBawnEditionsFactory;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;
import fr.martinfimbel.switchuhc.persistence.PersistenceFactory;

public class SpawnEditionsFactory extends AbstractBawnEditionsFactory<ISpawn> {

	public static SpawnEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private SpawnEditionsFactory(IPersistence<ISpawn> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final SpawnEditionsFactory factory = new SpawnEditionsFactory(PersistenceFactory.getInstance().getSpawnPersistence());
	}

	@Override
	public IMapEdition<ISpawn> createDimensionsEdition() {
		return new DimensionsSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createNewEdition() {
		return new NewSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createExtractEdition() {
		return new ExtractSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createRenameEdition() {
		return new RenameSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createSaveEdition() {
		return new SaveSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createDeleteEdition() {
		return new DeleteSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createResetEdition() {
		return new ResetSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createListEdition() {
		return new ListSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createCurrentEdition() {
		return new CurrentSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createLaunchEdition() {
		return new LaunchSpawn();
	}

	@Override
	public IMapEdition<ISpawn> createRemoveEdition() {
		return new RemoveSpawn();
	}

	public IMapEdition<ISpawn> createRandomEdition() {
		return new RandomSpawn();
	}

	public IMapEdition<ISpawn> createPlayerSpawnEdition() {
		return new PlayerSpawn();
	}
}
