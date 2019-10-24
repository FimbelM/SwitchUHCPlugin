package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.interfaces.ISpawn;

public class CurrentSpawn extends AbstractBawnEdition<ISpawn> {

	public CurrentSpawn() {
		super("current", "to know the current spawn's name");
	}

	@Override
	public String edit(String[] args) {
		return "Current spawn " + get().getName();
	}
}
