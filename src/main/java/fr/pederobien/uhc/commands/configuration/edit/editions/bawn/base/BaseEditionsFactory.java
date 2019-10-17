package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEditionsFactory;
import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.persistence.PersistenceFactory;
import fr.pederobien.uhc.world.blocks.IBase;

public class BaseEditionsFactory extends AbstractBawnEditionsFactory<IBase> {

	public static BaseEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private BaseEditionsFactory(IPersistence<IBase> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final BaseEditionsFactory factory = new BaseEditionsFactory(
				PersistenceFactory.getInstance().getBasePersistence());
	}
	
	@Override
	public IEdition createExtractEdition() {
		return new ExtractBase(persistence);
	}

	@Override
	public IEdition createRenameEdition() {
		return new RenameBase(persistence);
	}

	@Override
	public IEdition createListEdition() {
		return new ListBase(persistence);
	}

	@Override
	public IEdition createCurrentEdition() {
		return new CurrentBase(persistence);
	}

	@Override
	public IEdition createNewEdition() {
		return new NewBase(persistence);
	}

	@Override
	public IEdition createSaveEdition() {
		return new SaveBase(persistence);
	}
	
	public IEdition createLoadTempEdition() {
		return new LoadBaseTemp(persistence);
	}
	
	public IEdition createLaunchTempEdition() {
		return new LaunchBaseTemp(persistence);
	}
}
