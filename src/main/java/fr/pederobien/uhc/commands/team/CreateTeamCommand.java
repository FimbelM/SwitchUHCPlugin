package fr.pederobien.uhc.commands.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.managers.TeamsManager;

public class CreateTeamCommand extends AbstractCommand {

	public CreateTeamCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		for (String arg : args) {
			String[] info = arg.split(";");
			if (info.length == 2)
				TeamsManager.createTeam(info[0], info[1]);
			else if (info.length == 1)
				TeamsManager.createTeam(info[0]);
			else
				sendMessageToSender(sender, "Cannot create team");

		}
		return false;
	}
}
