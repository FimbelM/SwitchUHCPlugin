package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEditionsFactory;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class BaseEditionsFactory extends AbstractBawnEditionsFactory<IBase> {

	public static BaseEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private BaseEditionsFactory(IPersistence<IBase> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final BaseEditionsFactory factory = new BaseEditionsFactory(PersistenceFactory.getInstance().getBasePersistence());
	}

	@Override
	public IMapEdition<IBase> createDimensionsEdition() {
		return new DimensionsBase();
	}

	@Override
	public IMapEdition<IBase> createExtractEdition() {
		return new ExtractBase();
	}

	@Override
	public IMapEdition<IBase> createRenameEdition() {
		return new RenameBase();
	}

	@Override
	public IMapEdition<IBase> createLaunchEdition() {
		return new LaunchBase();
	}

	@Override
	public IMapEdition<IBase> createListEdition() {
		return new ListBase();
	}

	@Override
	public IMapEdition<IBase> createCurrentEdition() {
		return new CurrentBase();
	}

	@Override
	public IMapEdition<IBase> createNewEdition() {
		return new NewBase();
	}

	@Override
	public IMapEdition<IBase> createSaveEdition() {
		return new SaveBase();
	}

	@Override
	public IMapEdition<IBase> createDeleteEdition() {
		return new DeleteBase();
	}

	@Override
	public IMapEdition<IBase> createRemoveEdition() {
		return new RemoveBase();
	}
}
