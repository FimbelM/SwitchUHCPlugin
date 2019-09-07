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
		this.persistence = new HungerGamePersistence();
	}

	@Override
	public boolean edit(String[] args) {
		switch (args[0]) {
		case "bordercenter":
			setBorderCenter(args);
			break;
		case "initialbordersize":
			setInitialBorderDiameter(args);
			break;
		case "finalbordersize":
			setFinalBorderDiameter(args);
			break;
		case "gametime":
			setGameTime(args);
			break;
		case "fractiontime":
			setFractionTime(args);
			break;
		case "scoreboardrefresh":
			setScoreboardRefresh(args);
			break;
		case "name":
			setName(args);
			break;
		case "load":
			load(args);
			break;
		case "new":
			newConfig(args);
			break;
		case "current":
			setMessage("Current configuration : " + getConfiguration().getName());
			break;
		case "ascurrent":
			asCurrent(args);
			break;
		case "save":
			persistence.save();
			setMessage("Configuration " + getConfiguration().getName() + " saved");
			break;
		case "list":
			setMessage(prepare(persistence.list(), "spawn"));
			break;
		default:
			return false;
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
				.append("load - to load the current hunger game style\r\n")
				.append("new - to create a new hunger game style\r\n")
				.append("current - to show the name of the current hunger game style's name\r\n")
				.append("ascurrent - to set the configuration as the current configuration to start\r\n")
				.append("save - to save the current hunger game style")
				.append("list - to list existing hunger game styles");
		return builder.toString();
	}

	protected HungerGameConfiguration getConfiguration() {
		return persistence.get();
	}

	private void setBorderCenter(String[] args) {
		try {
			getConfiguration().setBorderCenter(args[1], args[2]);
			setMessage("New border center : " + args[1] + " " + args[2]);
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define center's coordinates\nNeed two coordinates (X Z)");
		}
	}

	private void setInitialBorderDiameter(String[] args) {
		try {
			getConfiguration().setInitialBorderDiameter(Integer.parseInt(args[1]));
			setMessage("New initial border diameter " + args[1]);
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the initial diameter of the border\nNeed the diameter");
		}
	}

	private void setFinalBorderDiameter(String[] args) {
		try {
			getConfiguration().setFinalBorderDiameter(Integer.parseInt(args[1]));
			setMessage("New final border diameter " + args[1]);
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the final diameter of the border\nNeed the diameter");
		}
	}

	private void setGameTime(String[] args) {
		try {
			getConfiguration().setGameTime(LocalTime.parse(args[1]));
			setMessage("New game time " + getConfiguration().getGameTime());
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the game time\nThe value should have the pattern hh:mm:ss");
		}
	}

	private void setFractionTime(String[] args) {
		try {
			getConfiguration().setFractionTime(LocalTime.parse(args[1]));
			setMessage("New fraction time " + getConfiguration().getFractionTime());
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the fraction time\nThe value should have the pattern hh:mm:ss");
		}
	}

	private void setScoreboardRefresh(String[] args) {
		try {
			getConfiguration().setScoreboardRefresh(Long.parseLong(args[1]));
			setMessage("scoreboard refreshed each " + getConfiguration().getScoreboardRefresh() + "tics");
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the scoreboard refresh tics");
		} catch (NumberFormatException e) {
			setMessage("The value is not a Long number");
		}
	}

	private void setName(String[] args) {
		try {
			if (persistence.exist(args[1]))
				setMessage("A style with name " + args[1] + " already exist");
			else {
				getConfiguration().setName(args[1]);
				setMessage("New name : " + args[1]);
			}
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the style's name\nNeed the name");
		}
	}

	private void load(String[] args) {
		try {
			persistence.save();
			persistence.load(args[1]);
			setMessage("New configuration " + persistence.get().getName());
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to load the style\nNeed the name");
		} catch (FileNotFoundException e) {
			setMessage(e.getMessage());
		}
	}

	private void newConfig(String[] args) {
		try {
			persistence.save();
			if (persistence.exist(args[1]))
				setMessage("A configuration with name " + args[1] + " already exist");
			else {
				persistence.set(new HungerGameConfiguration(args[1]));
				setMessage("New configuration " + getConfiguration().getName() + " created");
			}
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the new hunger game style's name\nNeed the name");
		}
	}

	private void asCurrent(String[] args) {
		if (args.length == 1) {
			context.setCurrentConfiguration(persistence.get());
			setMessage("Game " + getConfiguration().getName() + " defined as current configuration");
		} else if (args.length == 2) {
			persistence.save();
			try {
				persistence.load(args[1]);
				context.setCurrentConfiguration(getConfiguration());
				setMessage(getConfiguration().getName() + " defined as current configuration");
			} catch (FileNotFoundException e) {
				setMessage(e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				setMessage("Impossible to define a new hunger game style's as current\nNeed the name");
			}
		}
	}
}
