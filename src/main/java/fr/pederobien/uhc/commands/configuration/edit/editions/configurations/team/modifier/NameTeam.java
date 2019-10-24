package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.modifier;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team.AbstractTeamEditions;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public class NameTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public NameTeam() {
		super("name", "to modify the name of a team");
	}
	
	@Override
	public String edit(String[] args) {
		String oldName = args[0], newName = args[1];
		ETeam team = ETeam.getByName(oldName);
		if (team == null)
			return oldName + "does not correspond to a team";
		team.setName(newName);
		return "Team " + newName + " renamed";
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getTeamNamesWithoutColor(), args[0]);
		case 2:
			return Arrays.asList("<NewName");
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
