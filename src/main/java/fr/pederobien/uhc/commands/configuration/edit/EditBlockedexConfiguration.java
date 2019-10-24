package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.managers.BaseManager;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private static final BlockedexGameEditionsFactory factory = BlockedexGameEditionsFactory.getInstance();
	private IMapEdition bases;

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "bd", "to configure a blockedex game style");

		IMapEdition load = factory.createLoadEdition();
		IMapEdition newConf = factory.createNewEdition();
		bases = factory.createBasesEdition();
		
		addEditions(factory.createGameTimeEdition(),
				factory.createScoreboardRefreshEdition(),
				factory.createRenameEdition(),
				load, newConf,
				factory.createCurrentEdition(),
				factory.createAsCurrentEdition(context),
				factory.createSaveEdition(),
				factory.createListEdition(),
				factory.createHelpEdition(this),
				bases,
				factory.createBaseDistanceEdition(),
				factory.createTeamEdition());
		
		getEditions().get(load.getLabel()).setAvailable(true);
		getEditions().get(newConf.getLabel()).setAvailable(true);
	}
	
	@Override
	public String edit(String[] args) {
		String message = super.edit(args);
		if (get().getTeams().size() > 0)
			bases.setAvailable(true);
		return message;
	}
	
	@Override
	public void onBeforeLaunching() {
		BaseManager.loadPersistences();
	}
	
	@Override
	public void onLoaded() {
		availableAll();
		bases.setAvailable(false);
	}
	
	@Override
	public void onNewCreated() {
		availableAll();
		bases.setAvailable(false);
	}
}
