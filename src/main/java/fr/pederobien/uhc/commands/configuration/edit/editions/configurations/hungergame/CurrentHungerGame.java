package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class CurrentHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public CurrentHungerGame() {
		super("current", "to know the name of the current hunger game style");
	}

	@Override
	public String edit(String[] args) {
		return "Current hunger game style " + get().getName();
	}
}
