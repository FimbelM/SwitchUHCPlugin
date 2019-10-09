package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class SpawnEditionsFactory {
	private IPersistence<ISpawn> persistence = ConfigurationsFactory.getInstance().getSpawnPersistence();

	public static SpawnEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final SpawnEditionsFactory factory = new SpawnEditionsFactory();
	}

	public IEdition createCenterEdition() {
		return new Center(persistence);
	}

	public IEdition createDimensionsEdition() {
		return new Dimensions(persistence);
	}

	public IEdition createRenameEdition() {
		return new Rename(persistence);
	}

	public IEdition createCurrentEdition() {
		return new Current(persistence);
	}

	public IEdition createNewSpawnEdition() {
		return new NewSpawn(persistence);
	}

	public IEdition createLaunchEdition() {
		return new Launch(persistence);
	}

	public IEdition createSaveEdition() {
		return new Save(persistence);
	}

	public IEdition createRemoveEdition() {
		return new Remove(persistence);
	}

	public IEdition createExtractEdition() {
		return new Extract(persistence);
	}

	public IEdition createListEdition() {
		return new ListSpawn(persistence);
	}

	public IEdition createHelpEdition() {
		return new Help(persistence);
	}
}
