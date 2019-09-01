package fr.pederobien.uhc.commands.configuration.edit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;

public class EditConfigurationCommand extends AbstractCommand {
	private IEditConfig editHungerGame;

	public EditConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
		editHungerGame = new EditHungerGameConfiguration(confContext);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String[] arguments = new String[args.length - 1];
		for (int i = 1; i < args.length; i++)
			arguments[i - 1] = args[i];
		
		switch (args[0]) {
		case "hungergame":
			if (editHungerGame.edit(arguments))
				sendMessageToSender(sender, editHungerGame.getMessage());
			else
				sendMessageToSender(sender, editHungerGame.getEditCommands());
			break;

		default:
			break;
		}
		
		return false;
	}
}
