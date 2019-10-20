package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.AddPlayer;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.AddTeam;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.MovePlayer;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.RemovePlayer;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.RemoveTeam;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class CommonTeam<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonTeam(IPersistence<T> persistence) {
		super(persistence, "team", "to manage team for game style");

		addEditions(new AddPlayer<T>(persistence), new AddTeam<T>(persistence), new MovePlayer<T>(persistence),
				new RemovePlayer<T>(persistence), new RemoveTeam<T>(persistence));
	}
}
