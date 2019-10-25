package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonLaunch;
import fr.pederobien.uhc.interfaces.IBase;

public class LaunchBase extends CommonLaunch<IBase> {

	public LaunchBase() {
		super("to launch a base in the world");
	}

	@Override
	protected String onLaunch() {
		return "Base " + get().getName() + " launched at " + showBlock(get().getCenter());
	}

	@Override
	protected String onNotExist(String name) {
		return "Cannot launch base " + name + ", base does not exist";
	}

	@Override
	protected String onNeedNameAndCoordinates(String name) {
		return "Cannot launch base " + name + ", need the base's name and center's coordinates <X> <Y> <Z>";
	}
}
