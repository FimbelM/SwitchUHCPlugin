package fr.pederobien.uhc.commands.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.managers.TeamsManager;

public class AddToRandomTeamCommand extends AbstractCommand {
	
	public AddToRandomTeamCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		TeamsManager.dispatchPlayerRandomlyInTeam();
		return true;
	}
}
