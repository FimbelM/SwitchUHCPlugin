package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonLaunch;
import fr.pederobien.uhc.interfaces.ISpawn;

public class LaunchSpawn extends CommonLaunch<ISpawn> {

	public LaunchSpawn() {
		super("to launch a spawn in the world");
	}

	@Override
	protected String onLaunch() {
		return "Spawn " + get().getName() + " launched at " + showBlock(get().getCenter());
	}

	@Override
	protected String onNotExist(String name) {
		return "Cannot launch spawn " + name + ", spawn does not exist";
	}

	@Override
	protected String onNeedNameAndCoordinates(String name) {
		return "Cannot launch spawn " + name + ", need the spawn's name and center's coordinates <X> <Y> <Z>";
	}
}
