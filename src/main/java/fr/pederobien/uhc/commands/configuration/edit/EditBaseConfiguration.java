package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base.BaseEditionsFactory;

public class EditBaseConfiguration extends AbstractMapEdition {
	private BaseEditionsFactory factory = BaseEditionsFactory.getInstance();

	public EditBaseConfiguration() {
		super("base", "to configure a base");

		addEditions(factory.createCenterEdition(),
				factory.createCurrentEdition(),
				factory.createDimensionsEdition(),
				factory.createExtractEdition(),
				factory.createHelpEdition(this),
				factory.createListEdition(),
				factory.createNewEdition(),
				factory.createRenameEdition(),
				factory.createSaveEdition(),
				factory.createLaunchEdition(),
				factory.createRemoveEdition());
	}
}
