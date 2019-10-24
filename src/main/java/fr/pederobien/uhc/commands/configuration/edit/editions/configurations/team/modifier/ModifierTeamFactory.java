package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.modifier;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;

public class ModifierTeamFactory<T extends IConfiguration> {

	public IMapEdition<T> createModifieurColorTeam() {
		return new ColorTeam<T>();
	}
	
	public IMapEdition<T> createModifieurNameTeam() {
		return new NameTeam<T>();
	}
}
