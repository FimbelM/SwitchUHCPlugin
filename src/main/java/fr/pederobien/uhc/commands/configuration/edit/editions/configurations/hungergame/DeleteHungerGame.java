package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class DeleteHungerGame extends CommonDelete<IHungerGameConfiguration> {

	public DeleteHungerGame() {
		super("to delete an hunger game style");
	}

	@Override
	protected String onDeleted(String name) {
		return "Hunger game style " + name + " deleted";
	}

}
