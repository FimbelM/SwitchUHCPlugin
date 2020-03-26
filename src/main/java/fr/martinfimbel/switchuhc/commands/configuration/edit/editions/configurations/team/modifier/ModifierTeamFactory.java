package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team.modifier;

import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;

public class ModifierTeamFactory<T extends IConfiguration> {

	public IMapEdition<T> createModifieurColorTeam() {
		return new ColorTeam<T>();
	}

	public IMapEdition<T> createModifieurNameTeam() {
		return new NameTeam<T>();
	}
}
