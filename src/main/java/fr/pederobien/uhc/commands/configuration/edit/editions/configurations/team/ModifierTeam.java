package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.modifier.ModifierTeamFactory;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;

public class ModifierTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {
	private final ModifierTeamFactory<T> factory = new ModifierTeamFactory<>();

	public ModifierTeam() {
		super("modify", MessageCode.TEAM_MODIFY_EXPLANATION);

		addEdition(factory.createModifieurColorTeam()).addEdition(factory.createModifieurNameTeam());
	}
}
