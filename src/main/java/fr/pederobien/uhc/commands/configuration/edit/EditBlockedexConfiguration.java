package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IMapEdition;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private static final BlockedexGameEditionsFactory factory = BlockedexGameEditionsFactory.getInstance();

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "bd", "to configure a blockedex game style");

		IMapEdition<IBlockedexConfiguration> load = factory.createLoadEdition();
		IMapEdition<IBlockedexConfiguration> newConf = factory.createNewEdition();
		
		addEdition(factory.createAsCurrentEdition(context))
		.addEdition(factory.createBaseDistanceEdition())
		.addEdition(factory.createBasesEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createGameTimeEdition())
		.addEdition(factory.createHelpEdition(this))
		.addEdition(factory.createListEdition())
		.addEdition(load)
		.addEdition(newConf)
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition())
		.addEdition(factory.createScoreboardRefreshEdition())
		.addEdition(factory.createTeamEdition());
		
		getEditions().get(load.getLabel()).setAvailable(true);
		getEditions().get(newConf.getLabel()).setAvailable(true);
	}
	
	/*@Override
	public String edit(String[] args) {
		String message = super.edit(args);
		if (get().getTeams().size() > 0)
			bases.setAvailable(true);
		return message;
	}*/
	
	/*@Override
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
	}*/
}
