package fr.pederobien.uhc.commands.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.managers.TeamsManager;

public class RemoveAllTeamCommand extends AbstractCommand {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		TeamsManager.removeAllTeam();
		sendMessageToSender(sender, "All team has been removed");
		return false;
	}

}
