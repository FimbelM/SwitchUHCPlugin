package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.TeamEditionsFactory;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;

public class CommonTeam<T extends IConfiguration> extends AbstractConfEdition<T> {
	private final TeamEditionsFactory<T> factory = new TeamEditionsFactory<T>();

	public CommonTeam() {
		super("team", MessageCode.TEAM_EXPLANATION);

		addEdition(factory.createAddPlayerEdition()).addEdition(factory.createAddTeamEdition()).addEdition(factory.createListTeamEdition())
				.addEdition(factory.createModifierTeam()).addEdition(factory.createMovePlayerEdition()).addEdition(factory.createRandomTeamEdition())
				.addEdition(factory.createRemovePlayerEdition()).addEdition(factory.createRemoveTeamEdition());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
			return super.onTabComplete(sender, command, alias, args);
		} catch (IllegalArgumentException e) {
			return emptyList();
		}
	}
}
