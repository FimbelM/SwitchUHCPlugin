package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.modifier;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.AbstractTeamEditions;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public class ColorTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public ColorTeam() {
		super("color", MessageCode.TEAM_MODIFY_COLOR_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		ETeam oldTeam = ETeam.getByName(args[0]);
		if (oldTeam == null)
			return MessageCode.TEAM_BAD_TEAM.withArgs(args[0]);
		ETeam newTeam = ETeam.getByColorName(args[1]);
		if (newTeam == null)
			return MessageCode.TEAM_BAD_COLOR.withArgs(args[1]);

		newTeam.setName(oldTeam.getNameWithoutColor());
		oldTeam.resetName();
		newTeam.addPlayers(oldTeam.getPlayers());
		oldTeam.removeAllPlayers();

		get().removeTeam(oldTeam);
		get().addTeam(newTeam);
		return MessageCode.TEAM_MODIFY_COLOR_MODIFIED.withArgs(newTeam.getNameWithColor());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getTeamNamesWithoutColor(), args[0]);
		case 2:
			ETeam team = ETeam.getByName(args[0]);
			if (team == null)
				return emptyList();
			return filter(getAvailableColors(), args[1]);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
