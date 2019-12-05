package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base.BaseEditionsFactory;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class EditBaseConfiguration extends AbstractEditConfiguration<IBase> {
	private static final BaseEditionsFactory factory = BaseEditionsFactory.getInstance();

	public EditBaseConfiguration() {
		super(factory.getPersistence(), "base", MessageCode.BASE_EDITION_CONFIGURATION_EXPLANATION);
				
		addEdition(factory.createCenterEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createDeleteEdition().setModifiable(false))
		.addEdition(factory.createDimensionsEdition())
		.addEdition(factory.createExtractEdition())
		.addEdition(factory.createLaunchEdition().setModifiable(false))
		.addEdition(factory.createListEdition())
		.addEdition(factory.createNewEdition().setModifiable(false))
		.addEdition(factory.createRemoveEdition())
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition());
		
		setAvailable(false);
	}
}
