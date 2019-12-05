package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonLaunch;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class LaunchSpawn extends CommonLaunch<ISpawn> {

	public LaunchSpawn() {
		super(MessageCode.LAUNCH_SPAWN_EXPLANATION);
	}

	@Override
	protected MessageCode onLaunch() {
		return MessageCode.LAUNCH_SPAWN_LAUNCHED.withArgs(get().getName(), "" + get().getCenter().getX(), "" + get().getCenter().getY(), "" + get().getCenter().getZ());
	}

	@Override
	protected MessageCode onNotExist(String name) {
		return MessageCode.LAUNCH_SPAWN_NOT_EXISTING.withArgs(name);
	}
	
	@Override
	protected MessageCode onNeedCoordinates(String name) {
		return MessageCode.LAUNCH_SPAWN_MISSING_COORDINATES.withArgs(name);
	}

	@Override
	protected MessageCode onNeedNameAndCoordinates(String name) {
		return MessageCode.LAUNCH_SPAWN_MISSING_NAME_AND_COORDINATES.withArgs(name);
	}
}
