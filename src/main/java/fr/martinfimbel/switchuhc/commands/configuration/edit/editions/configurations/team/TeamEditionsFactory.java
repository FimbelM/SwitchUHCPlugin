package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team;

import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;

public class TeamEditionsFactory<T extends IConfiguration> {

	public IMapEdition<T> createAddPlayerEdition() {
		return new AddPlayer<T>();
	}

	public IMapEdition<T> createAddTeamEdition() {
		return new AddTeam<T>();
	}

	public IMapEdition<T> createListTeamEdition() {
		return new ListTeam<T>();
	}

	public IMapEdition<T> createMovePlayerEdition() {
		return new MovePlayer<T>();
	}

	public IMapEdition<T> createRandomTeamEdition() {
		return new RandomTeam<T>();
	}

	public IMapEdition<T> createRemovePlayerEdition() {
		return new RemovePlayer<T>();
	}

	public IMapEdition<T> createRemoveTeamEdition() {
		return new RemoveTeam<T>();
	}

	public IMapEdition<T> createModifierTeam() {
		return new ModifierTeam<T>();
	}
}
