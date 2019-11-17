package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonLaunch;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.managers.ETeam;

public class LaunchBase extends CommonLaunch<IBase> {

	public LaunchBase() {
		super("to launch a base in the world");
	}

	@Override
	protected String onLaunch() {
		String base = "Base " + get().getName() + " launched at " + showBlock(get().getCenter()) + "\n";
		switch (get().getChestsNumber()) {
		case 0:
			base += "No team color supported";
			break;
		case 1:
			base += "Team color " + get().getChests().values().iterator().next().getNameWithColor();
			break;
		default:
			String teamColors = "";
			for (ETeam team : get().getChests().values())
				teamColors += team.getColorNameWithColor() + " ";
			base += "Team color supported : " + teamColors;
		}
		return base;
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
