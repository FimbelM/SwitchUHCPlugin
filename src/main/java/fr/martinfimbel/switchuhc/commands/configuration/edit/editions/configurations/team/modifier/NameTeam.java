package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team.modifier;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team.AbstractTeamEditions;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ITeam;

public class NameTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public NameTeam() {
		super("name", MessageCode.TEAM_MODIFY_NAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		String oldName = args[0], newName = args[1];
		ITeam team = get().getTeamByName(oldName);

		if (team == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, oldName);
			return;
		}

		if (newName.equals(oldName)) {
			sendMessage(MessageCode.TEAM_MODIFY_NAME_UNCHANGED, team.getColoredName());
			return;
		}

		if (!isNameForbidden(newName) || !isNameValide(newName))
			return;

		team.setName(newName);
		sendMessage(MessageCode.TEAM_MODIFY_NAME_MODIFIED, team.getColor().getInColor(oldName), team.getColoredName());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getTeamNamesWithoutColor(), args[0]);
		case 2:
			return Arrays.asList(onTabComplete(sender, MessageCode.RENAME_TAB_COMPLETE));
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
