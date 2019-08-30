package fr.pederobien.uhc.commands.configuration.hungergame;

import java.io.FileNotFoundException;
import java.time.LocalTime;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;

public class HungerGameEditCommand extends AbstractHungerGameCommand {
	private String message;

	public HungerGameEditCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			switch (args[0]) {
			case "bordercenter":
				getConfiguration().setBorderCenter(args[1], args[2], args[3]);
				setMessage("new border center : " + args[1] + " " + args[2] + " " + args[3]);
				break;
			case "initialbordersize":
				getConfiguration().setInitialBorderSize(Integer.parseInt(args[1]));
				setMessage("new initial border size " + args[1]);
				break;
			case "finalbordersize":
				getConfiguration().setFinalBorderSize(Integer.parseInt(args[1]));
				setMessage("new final border size " + args[1]);
				break;
			case "gametime":
				getConfiguration().setGameTime(LocalTime.parse(args[1]));
				setMessage("new game time " + getConfiguration().getGameTime());
				break;
			case "fractiontime":
				getConfiguration().setFractionTime(LocalTime.parse(args[1]));
				setMessage("new fraction time " + getConfiguration().getFractionTime());
				break;
			case "scoreboardrefresh":
				getConfiguration().setScoreboardRefresh(Long.parseLong(args[1]));
				setMessage("scoreboard refreshed each " + getConfiguration().getScoreboardRefresh() + "tics");
			case "name":
				if (hungergamePersistence.exist(args[1])) {
					if (args.length == 2)
						message = "A configuration with name " + args[1]
								+ " already exist\nIf you want to overrite it add -f";
					else if (args.length == 3 && args[2].equals("-f")) {
						hungergamePersistence.delete(args[1]);
						hungergamePersistence.delete(getConfiguration().getName());
						getConfiguration().setName(args[1]);
						hungergamePersistence.save();
						setMessage("new name : " + args[1]);
					}
				} else {
					getConfiguration().setName(args[1]);
					setMessage("new name : " + args[1]);
				}
				break;
			case "set":
				hungergamePersistence.save();
				hungergamePersistence.load(args[1]);
				setMessage("new spawn");
			case "new":
				if (hungergamePersistence.exist(args[1]))
					message = "A configuration with name " + args[1] + " already exist";
				else {
					hungergamePersistence.save();
					hungergamePersistence.set(new HungerGameConfiguration(args[1]));
					setMessage("new configuration");
				}
			default:
				message = "Unkonown command";
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
		this.message += " for configuration " + hungergamePersistence.get().getName();
	}

	private HungerGameConfiguration getConfiguration() {
		return hungergamePersistence.get();
	}
}
