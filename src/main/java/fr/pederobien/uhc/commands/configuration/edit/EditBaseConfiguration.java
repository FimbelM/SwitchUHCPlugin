package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base.BaseEditionsFactory;
import fr.pederobien.uhc.interfaces.IBase;

public class EditBaseConfiguration extends AbstractEditConfiguration<IBase> {
	private static final BaseEditionsFactory factory = BaseEditionsFactory.getInstance();

	public EditBaseConfiguration() {
		super(factory.getPersistence(), "base", "to configure a base");

		/*IMapEdition launch = factory.createLaunchEdition();
		IMapEdition newBase = factory.createNewEdition();
		
		addEditions(factory.createCenterEdition(),
				factory.createCurrentEdition(),
				factory.createDimensionsEdition(),
				factory.createExtractEdition(),
				factory.createHelpEdition(this),
				factory.createListEdition(),
				newBase, launch,
				factory.createRenameEdition(),
				factory.createSaveEdition(),
				factory.createRemoveEdition());
		
		getEditions().get(launch.getLabel()).setAvailable(true);
		getEditions().get(newBase.getLabel()).setAvailable(true);*/
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
