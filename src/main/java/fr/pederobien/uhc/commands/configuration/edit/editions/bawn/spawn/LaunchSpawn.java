package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonLaunch;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class LaunchSpawn extends CommonLaunch<ISpawn> {

	public LaunchSpawn() {
		super(MessageCode.LAUNCH_SPAWN_EXPLANATION);
	}

	@Override
	protected void onLaunch() {
		sendMessage(MessageCode.LAUNCH_SPAWN_LAUNCHED, get().getName(), "" + get().getCenter().getX(), "" + get().getCenter().getY(),
				"" + get().getCenter().getZ());
	}

	@Override
	protected void onNotExist(String name) {
		sendMessage(MessageCode.LAUNCH_SPAWN_NOT_EXISTING, name);
	}

	@Override
	protected void onNeedCoordinates(String name) {
		sendMessage(MessageCode.LAUNCH_SPAWN_MISSING_COORDINATES, name);
	}

	@Override
	protected void onNeedNameAndCoordinates(String name) {
		sendMessage(MessageCode.LAUNCH_SPAWN_MISSING_NAME_AND_COORDINATES, name);
	}
}
