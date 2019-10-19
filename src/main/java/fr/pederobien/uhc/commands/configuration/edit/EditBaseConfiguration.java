package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base.BaseEditionsFactory;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class EditBaseConfiguration extends AbstractEditConfiguration<IBase> {
	private BaseEditionsFactory factory = BaseEditionsFactory.getInstance();

	public EditBaseConfiguration(IConfigurationContext context) {
		super(context, "base", "to configure a base");

		addEditions(factory.createCenterEdition(),
				factory.createCurrentEdition(),
				factory.createDimensionsEdition(),
				factory.createExtractEdition(),
				factory.createHelpEdition(this),
				factory.createListEdition(),
				factory.createNewEdition(),
				factory.createRenameEdition(),
				factory.createSaveEdition(),
				factory.createLoadTempEdition(),
				factory.createLaunchTempEdition());
	}
}
