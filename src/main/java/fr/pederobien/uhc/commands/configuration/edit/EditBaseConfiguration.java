package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base.BaseEditionsFactory;
import fr.pederobien.uhc.interfaces.IBase;

public class EditBaseConfiguration extends AbstractEditConfiguration<IBase> {
	private static final BaseEditionsFactory factory = BaseEditionsFactory.getInstance();

	public EditBaseConfiguration() {
		super(factory.getPersistence(), "base", "to configure a base");
				
		addEdition(factory.createCenterEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createDeleteEdition().setUnmodifiable(true))
		.addEdition(factory.createDimensionsEdition())
		.addEdition(factory.createExtractEdition())
		.addEdition(factory.createHelpEdition(this).setUnmodifiable(true))
		.addEdition(factory.createLaunchEdition().setUnmodifiable(true))
		.addEdition(factory.createListEdition())
		.addEdition(factory.createNewEdition().setUnmodifiable(true))
		.addEdition(factory.createRemoveEdition())
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition());
		
		setAvailable(false);
	}
}
