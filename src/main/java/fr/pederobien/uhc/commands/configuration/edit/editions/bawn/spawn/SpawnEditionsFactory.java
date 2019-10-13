package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEditionsFactory;
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class SpawnEditionsFactory extends AbstractBawnEditionsFactory<ISpawn> {

	public static SpawnEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private SpawnEditionsFactory(IPersistence<ISpawn> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final SpawnEditionsFactory factory = new SpawnEditionsFactory(
				ConfigurationsFactory.getInstance().getSpawnPersistence());
	}

	@Override
	public IEdition createNewEdition() {
		return new NewSpawn(persistence);
	}

	@Override
	public IEdition createRemoveEdition() {
		return new RemoveSpawn(persistence);
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
	
	public IEdition createLaunchEdition() {
		return new LaunchSpawn(persistence);
	}
}