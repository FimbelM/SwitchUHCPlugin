package fr.pederobien.uhc.commands.configuration.edit;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

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
	protected void setEditions() {
		editions.add(new Edition("bordercenter", "to set the center of the world's border",
				"need two numbers that represent the two dimensions : X and Z"));
		editions.add(new Edition("initialborderdiameter", "to set the initial diameter of the world's border",
				"need one number parameter that represent the diameter of the world border"));
		editions.add(new Edition("finalborderdiameter", "to set the initial diameter of the world's border",
				"need one number parameter that represent the diameter of the world border"));
		editions.add(new Edition("gametime",
				"to set the time before which the world border move from its initial to final diameter",
				"need a time at the format hh:mm:ss"));
		editions.add(
				new Edition("fractiontime", "to set the time before which players will not respawn in survivor mode",
						"need a time at the format hh:mm:ss"));
		editions.add(new Edition("scoreboardrefresh",
				"to set the number of servers's tic after which the scoreboard of each player is refreshed",
				"need one number argument which should be striclty positive"));
		editions.add(new Edition("name", "to change the name of current hunger game style",
				"need one argument which is the name of the new hunger game style"));
		editions.add(new Edition("load", "to load the current hunger game style",
				"need one argument which is the name of the hunger game style to load"));
		editions.add(new Edition("new", "to create a new hunger game style",
				"need one argument which is the name of the new hunger game style"));
		editions.add(new Edition("current", "to know the current hunger game style", "need no arguments"));
		editions.add(new Edition("ascurrent", "to set the current hunger game as the current configuration",
				"need no arguments"));
		editions.add(new Edition("save", "to save the current hunger game style",
				"two possibilities :\nno arguments and save the hunger game style\none argument which is the new name of the hunger game style"));
		editions.add(new Edition("list", "to display all existing hunger game style", "need no arguments"));
	}

	@Override
	public boolean edit(String[] args) {
		try {
			switch (args[0]) {
			case "bordercenter":
				setBorderCenter(args);
				break;
			case "initialborderdiameter":
				setInitialBorderDiameter(args);
				break;
			case "finalborderdiameter":
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
				save(args);
				break;
			case "list":
				setMessage(prepare(persistence.list(), "spawn"));
				break;
			default:
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	@Override
	public String getEditCommands() {
		return new StringBuilder("Unknown command\r\n").append(getEditionsHelp()).toString();
	}

	protected HungerGameConfiguration getConfiguration() {
		return persistence.get();
	}

	private void setBorderCenter(String[] args) {
		try {
			getConfiguration().setBorderCenter(args[1], args[2]);
			setMessage("New border center : " + args[1] + " " + args[2] + " defined");
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			setMessage(getEdition("bordercenter").getExpectedArgs());
		}
	}

	private void setInitialBorderDiameter(String[] args) {
		try {
			getConfiguration().setInitialBorderDiameter(Integer.parseInt(args[1]));
			setMessage("New initial border diameter " + args[1] + " defined");
		} catch (IndexOutOfBoundsException e) {
			setMessage(getEdition("initialborderdiameter").getExpectedArgs());
		}
	}

	private void setFinalBorderDiameter(String[] args) {
		try {
			getConfiguration().setFinalBorderDiameter(Integer.parseInt(args[1]));
			setMessage("New final border diameter " + args[1] + " defined");
		} catch (IndexOutOfBoundsException e) {
			setMessage(getEdition("finalborderdiameter").getExpectedArgs());
		}
	}

	private void setGameTime(String[] args) {
		try {
			getConfiguration().setGameTime(LocalTime.parse(args[1]));
			setMessage("New game time " + showTime(getConfiguration().getGameTime()) + " defined");
		} catch (IndexOutOfBoundsException | DateTimeParseException e) {
			setMessage(getEdition("gametime").getExpectedArgs());
		}
	}

	private void setFractionTime(String[] args) {
		try {
			getConfiguration().setFractionTime(LocalTime.parse(args[1]));
			setMessage("New fraction time " + showTime(getConfiguration().getFractionTime()) + " defined");
		} catch (IndexOutOfBoundsException | DateTimeParseException e) {
			setMessage(getEdition("fractiontime").getExpectedArgs());
		}
	}

	private void setScoreboardRefresh(String[] args) {
		try {
			getConfiguration().setScoreboardRefresh(Long.parseLong(args[1]));
			setMessage("Scoreboard refreshed each " + getConfiguration().getScoreboardRefresh() + " tics");
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			setMessage(getEdition("scoreboardrefresh").getExpectedArgs());
		}
	}

	private void setName(String[] args) {
		try {
			if (persistence.exist(args[1]))
				setMessage("A style with name " + args[1] + " already exist");
			else {
				String oldName = getConfiguration().getName();
				getConfiguration().setName(args[1]);
				setMessage("Configuration " + oldName + " renamed " + args[1]);
			}
		} catch (IndexOutOfBoundsException e) {
			setMessage(getEdition("name").getExpectedArgs());
		}
	}

	private void load(String[] args) {
		try {
			persistence.save();
			persistence.load(args[1]);
			setMessage("New configuration " + persistence.get().getName() + " loaded");
		} catch (IndexOutOfBoundsException | FileNotFoundException e) {
			setMessage(getEdition("load").getExpectedArgs());
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
			setMessage(getEdition("new").getExpectedArgs());
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
			} catch (IndexOutOfBoundsException | FileNotFoundException e) {
				setMessage(getEdition("ascurrent").getExpectedArgs());
			}
		}
	}

	private void save(String[] args) {
		try {
			if (args.length == 1) {
				persistence.save();
				setMessage("Configuration " + getConfiguration().getName() + " saved");
			} else {
				getConfiguration().setName(args[2]);
				persistence.save();
				setMessage("Current hunger game style renamed " + getConfiguration().getName() + " and saved");
			}
		} catch (IndexOutOfBoundsException e) {
			setMessage(getEdition("save").getExpectedArgs());
		}
	}

	private String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}
}
