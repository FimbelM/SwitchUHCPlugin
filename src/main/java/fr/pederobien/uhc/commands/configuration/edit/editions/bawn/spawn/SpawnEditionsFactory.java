package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEditionsFactory;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.ISpawn;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class SpawnEditionsFactory extends AbstractBawnEditionsFactory<ISpawn> {

	public static SpawnEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private SpawnEditionsFactory(IPersistence<ISpawn> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final SpawnEditionsFactory factory = new SpawnEditionsFactory(
				PersistenceFactory.getInstance().getSpawnPersistence());
	}

	@Override
	public IEdition createNewEdition() {
		return new NewSpawn(persistence);
	}

	@Override
	public IEdition createExtractEdition() {
		return new ExtractSpawn(persistence);
	}

	@Override
	public IEdition createRenameEdition() {
		return new RenameSpawn(persistence);
	}

	@Override
	public IEdition createSaveEdition() {
		return new SaveSpawn(persistence);
	}

	@Override
	public IEdition createListEdition() {
		return new ListSpawn(persistence);
	}

	@Override
	public IEdition createCurrentEdition() {
		return new CurrentSpawn(persistence);
	}

	public IEdition createRemoveEdition() {
		return new RemoveSpawn(persistence);
	}

	public IEdition createLaunchEdition() {
		return new LaunchSpawn(persistence);
	}
}
