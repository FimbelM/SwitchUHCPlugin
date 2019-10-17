package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base.BaseEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.world.blocks.IBase;

public class EditBaseConfiguration extends AbstractEditConfiguration<IBase> {
	private BaseEditionsFactory factory;
	
	public EditBaseConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected void setEditions() {
		factory = BaseEditionsFactory.getInstance();
		
		addToMap(factory.createCenterEdition(),
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
