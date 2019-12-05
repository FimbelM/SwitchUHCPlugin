package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonLaunch;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.managers.ETeam;

public class LaunchBase extends CommonLaunch<IBase> {

	public LaunchBase() {
		super(MessageCode.LAUNCH_BASE_EXPLANATION);
	}

	@Override
	protected MessageCode onLaunch() {
		switch (get().getChestsNumber()) {
		case 0:
			return MessageCode.LAUNCH_BASE_NO_TEAM_SUPPORTED.withArgs(get().getName(), "" + get().getCenter().getX(),
					"" + get().getCenter().getY(), "" + get().getCenter().getZ());
		case 1:
			return MessageCode.LAUNCH_BASE_NO_TEAM_SUPPORTED.withArgs(get().getName(), "" + get().getCenter().getX(),
					"" + get().getCenter().getY(), "" + get().getCenter().getZ(),
					get().getChests().values().iterator().next().getNameWithColor());
		default:
			String teamColors = "";
			for (ETeam team : get().getChests().values())
				teamColors += team.getColorNameWithColor() + " ";
			return MessageCode.LAUNCH_BASE_NO_TEAM_SUPPORTED.withArgs(get().getName(), "" + get().getCenter().getX(),
					"" + get().getCenter().getY(), "" + get().getCenter().getZ(), teamColors);
		}
	}

	@Override
	protected MessageCode onNotExist(String name) {
		return MessageCode.LAUNCH_BASE_NOT_EXISTING.withArgs(name);
	}

	@Override
	protected MessageCode onNeedCoordinates(String name) {
		return MessageCode.LAUNCH_BASE_MISSING_COORDINATES.withArgs(name);
	}

	@Override
	protected MessageCode onNeedNameAndCoordinates(String name) {
		return MessageCode.LAUNCH_BASE_MISSING_NAME_AND_COORDINATES.withArgs(name);
	}
}
