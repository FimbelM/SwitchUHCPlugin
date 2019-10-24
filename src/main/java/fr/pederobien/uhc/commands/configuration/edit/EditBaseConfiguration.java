package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base.BaseEditionsFactory;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IMapEdition;

public class EditBaseConfiguration extends AbstractEditConfiguration<IBase> {
	private static final BaseEditionsFactory factory = BaseEditionsFactory.getInstance();

	public EditBaseConfiguration() {
		super(factory.getPersistence(), "base", "to configure a base");

		IMapEdition<IBase> launch = factory.createLaunchEdition();
		IMapEdition<IBase> newBase = factory.createNewEdition();
		
		addEdition(factory.createCenterEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createDimensionsEdition())
		.addEdition(factory.createExtractEdition())
		.addEdition(factory.createHelpEdition(this))
		.addEdition(launch)
		.addEdition(factory.createListEdition())
		.addEdition(newBase)
		.addEdition(factory.createRemoveEdition())
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition());
		
		getEditions().get(launch.getLabel()).setAvailable(true);
		getEditions().get(newBase.getLabel()).setAvailable(true);
	}
	
	/*@Override
	public void onLoaded() {
		availableAll();
	}
	
	@Override
	public void onNewCreated() {
		availableAll();
	}*/
}
