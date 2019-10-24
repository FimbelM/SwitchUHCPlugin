package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import fr.pederobien.uhc.interfaces.IConfiguration;

public class CommonTeam<T extends IConfiguration> extends AbstractConfEdition<T> {
	//private static final TeamEditionsFactory factory = TeamEditionsFactory.getInstance();
	
	public CommonTeam() {
		super("team", "to manage team for game style");

		/*addEdition(factory.createAddPlayerEdition())
		.addEdition(factory.createAddTeamEdition())
		.addEdition(factory.createListTeamEdition())
		.addEdition(factory.createMovePlayerEdition())
		.addEdition(factory.createRandomTeamEdition())
		.addEdition(factory.createRemovePlayerEdition())
		.addEdition(factory.createRemoveTeamEdition());*/
	}
}
