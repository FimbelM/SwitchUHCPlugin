package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.modifier;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.AbstractTeamEditions;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public class NameTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public NameTeam() {
		super("name", MessageCode.TEAM_MODIFY_NAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		String oldName = args[0], newName = args[1];
		ETeam team = ETeam.getByName(oldName);

		if (team == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, oldName);
			return;
		}

		team.setName(newName);
		sendMessage(MessageCode.TEAM_MODIFY_NAME_MODIFIED, team.getColor() + oldName + ChatColor.RESET, team.getNameWithColor());
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getTeamNamesWithoutColor(), args[0]);
		case 2:
			return Arrays.asList(getMessageOnTabComplete(sender, MessageCode.RENAME_TAB_COMPLETE));
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
