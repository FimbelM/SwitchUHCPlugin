package fr.pederobien.uhc.commands.spawn;

import java.io.FileNotFoundException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class EditSpawnCommand extends AbstractSpawnCommand {
	private String message;

	public EditSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			switch (args[0]) {
			case "center":
				getSpawn().setCenter(args[1], args[2], args[3]);
				setMessage("new center : " + args[1] + " " + args[2] + " " + args[3]);
				break;
			case "dimension":
				getSpawn().setDimension(args[1], args[2], args[3]);
				setMessage("new dimension : " + args[1] + " " + args[2] + " " + args[3]);
				break;
			case "width":
				getSpawn().setWidth(Integer.parseInt(args[1]));
				setMessage("new width : " + args[1]);
				break;
			case "height":
				getSpawn().setHeight(Integer.parseInt(args[1]));
				setMessage("new height : " + args[1]);
				break;
			case "depth":
				getSpawn().setDepth(Integer.parseInt(args[1]));
				setMessage("new depth : " + args[1]);
				break;
			case "name":
				if (spawnPersistence.exist(args[1])) {
					if (args.length == 2)
						message = "A spawn with name " + args[1] + " already exist\nIf you want to overrite it add -f";
					else if (args.length == 3 && args[2].equals("-f")) {
						spawnPersistence.delete(args[1]);
						spawnPersistence.delete(getSpawn().getName());
						getSpawn().setName(args[1]);
						spawnPersistence.save();
						setMessage("new name : " + args[1]);
					}
				} else {
					getSpawn().setName(args[1]);
					setMessage("new name : " + args[1]);
				}
				break;
			case "set":
				spawnPersistence.load(args[1]);
				break;
			default:
				setMessage("Unknown command");
				break;
			}
		} catch (FileNotFoundException e) {
			message = e.getMessage();
		}
		sendMessageToSender(sender, message);
		return false;
	}

	private void setMessage(String message) {
		this.message = "Define ";
		this.message += message;
		this.message += " for spawn " + getSpawn().getName();
	}
}
