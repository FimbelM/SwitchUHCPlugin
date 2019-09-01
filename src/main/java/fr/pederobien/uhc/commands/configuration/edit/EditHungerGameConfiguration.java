package fr.pederobien.uhc.commands.configuration.edit;

import java.io.FileNotFoundException;
import java.time.LocalTime;

import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class EditHungerGameConfiguration extends AbstractEditConfiguration implements IEditConfig {
	private HungerGamePersistence persistence;

	public EditHungerGameConfiguration(ConfigurationContext context) {
		super(context);
		persistence = new HungerGamePersistence();
	}

	@Override
	public boolean edit(String[] args) {
		try {
			switch (args[0]) {
			case "bordercenter":
				getConfiguration().setBorderCenter(args[1], args[2], args[3]);
				setMessage("New border center : " + args[1] + " " + args[2] + " " + args[3]);
				break;
			case "initialbordersize":
				getConfiguration().setInitialBorderSize(Integer.parseInt(args[1]));
				setMessage("New initial border size " + args[1]);
				break;
			case "finalbordersize":
				getConfiguration().setFinalBorderSize(Integer.parseInt(args[1]));
				setMessage("New final border size " + args[1]);
				break;
			case "gametime":
				getConfiguration().setGameTime(LocalTime.parse(args[1]));
				setMessage("New game time " + getConfiguration().getGameTime());
				break;
			case "fractiontime":
				getConfiguration().setFractionTime(LocalTime.parse(args[1]));
				setMessage("New fraction time " + getConfiguration().getFractionTime());
				break;
			case "scoreboardrefresh":
				getConfiguration().setScoreboardRefresh(Long.parseLong(args[1]));
				setMessage("scoreboard refreshed each " + getConfiguration().getScoreboardRefresh() + "tics");
			case "name":
				if (persistence.exist(args[1])) {
					if (args.length == 2)
						setMessage("A configuration with name " + args[1]
								+ " already exist\nIf you want to overrite it add -f");
					else if (args.length == 3 && args[2].equals("-f")) {
						persistence.delete(args[1]);
						persistence.delete(getConfiguration().getName());
						getConfiguration().setName(args[1]);
						persistence.save();
						setMessage("New name : " + args[1]);
					}
				} else {
					getConfiguration().setName(args[1]);
					setMessage("New name : " + args[1]);
				}
				break;
			case "set":
				persistence.save();
				persistence.load(args[1]);
				setMessage("New configuration " + persistence.get().getName());
				break;
			case "new":
				if (persistence.exist(args[1]))
					setMessage("A configuration with name " + args[1] + " already exist");
				else {
					persistence.save();
					persistence.set(new HungerGameConfiguration(args[1]));
					setMessage("New configuration " + getConfiguration().getName() + " created");
				}
				break;
			case "current":
				setMessage("Current configuration : " + getConfiguration().getName());
				break;
			case "ascurrent":
				if (args.length == 0) {
					context.setCurrentConfiguration(persistence.get());
					setMessage("Game " + getConfiguration().getName() + " defined as current configuration");
				} else {
					persistence.save();
					try {
						persistence.load(args[0]);
						context.setCurrentConfiguration(getConfiguration());
						setMessage(getConfiguration().getName() + " defined as current configuration");
					} catch (FileNotFoundException e) {
						setMessage("Configuration " + args[0] + " does not exist");
					}
				}
				break;
			case "save":
				persistence.save();
				setMessage("Configuration " + getConfiguration().getName() + " saved");
			default:
				return false;
			}
		} catch (FileNotFoundException e) {
			setMessage(e.getMessage());
		}
		return true;
	}

	@Override
	public String getEditCommands() {
		StringBuilder builder = new StringBuilder("Unknown command\r\n");
		builder.append("bordercenter - to set the center of the world's border\r\n")
				.append("initialbordersize - to set the initial size of the world's border\r\n")
				.append("finalbordersize - to set the final size of the world border\r\n")
				.append("gametime - to set the time after which the world's border moves from the initial to the final size\r\n")
				.append("fractiontime - to set the time after which players will not revive when they die\r\n")
				.append("scoreboardrefresh - to set the number of servers's tic after which the scoreboard of each player is refreshed\r\n")
				.append("name - to set the name of the configuration\r\n")
				.append("set - to change the current hunger game style\r\n")
				.append("new - to create a new hunger game style\r\n")
				.append("current - to show the name of the current hunger game style's name\r\n")
				.append("ascurrent - to set the configuration as the current configuration to start\r\n")
				.append("save - to save the current hunger game style");
		return builder.toString();
	}

	protected HungerGameConfiguration getConfiguration() {
		return persistence.get();
	}
}
