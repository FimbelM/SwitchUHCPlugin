package fr.pederobien.uhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class StartCommand extends AbstractGameCommand {

	public StartCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			if (TeamsManager.getNumberOfPlayerInTeam() != PlayerManager.getNumberOfPlayer())
				sendMessageToSender(sender, "There are players that are not in a team");
			else {
				listener.removeObservers(PluginDeposit.plugin);
				listener.addObservers(confContext);
				confContext.initiate();
				confContext.start();
			}
		} catch(NullPointerException e) {
			sendMessageToSender(sender, "No game setted to be launch, use command edit to edit a new game");
		}
		return true;
	}
}
