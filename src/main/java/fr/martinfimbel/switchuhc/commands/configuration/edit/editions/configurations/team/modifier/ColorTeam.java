package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team.modifier;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team.AbstractTeamEditions;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.managers.EColor;

public class ColorTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public ColorTeam() {
		super("color", MessageCode.TEAM_MODIFY_COLOR_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		String name = args[0];
		ITeam team = get().getTeamByName(name);

		if (team == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, name);
			return;
		}

		EColor color = EColor.getByColorName(args[1]);
		if (color == null) {
			sendMessage(MessageCode.TEAM_BAD_COLOR, args[1]);
			return;
		}

		if (color.equals(team.getColor())) {
			sendMessage(MessageCode.TEAM_MODIFY_COLOR_UNCHANGED, team.getColoredName());
			return;
		}

		if (!isColorValide(color))
			return;

		team.setColor(color);
		sendMessage(MessageCode.TEAM_MODIFY_COLOR_MODIFIED, team.getColoredName());
		return;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getTeamNamesWithoutColor(), args[0]);
		case 2:
			ITeam team = get().getTeamByName(args[0]);
			if (team == null)
				return emptyList();
			return filter(getAvailableColors(), args[1]);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
