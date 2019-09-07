package fr.pederobien.uhc.commands.configuration.edit;

import java.io.FileNotFoundException;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class EditSpawnConfiguration extends AbstractEditConfiguration implements IEditConfig {
	private SpawnPersistence persistence;

	public EditSpawnConfiguration(ConfigurationContext context) {
		super(context);
		persistence = new SpawnPersistence();
	}

	@Override
	public boolean edit(String[] args) {
		switch (args[0]) {
		case "center":
			setCenter(args);
			break;
		case "dimension":
			setDimension(args);
			break;
		case "name":
			setName(args);
			break;
		case "new":
			newSpawn(args);
			break;
		case "current":
			setMessage("Current spawn : " + getSpawn().getName());
			break;
		case "launch":
			launch(args);
			break;
		case "save":
			persistence.save();
			setMessage("Spawn " + getSpawn().getName() + " saved");
			break;
		case "remove":
			getSpawn().remove();
			setMessage("Spawn " + getSpawn().getName() + " removed from the world");
			break;
		case "extract":
			getSpawn().extract();
			setMessage("Spawn " + getSpawn().getName() + " extracted");
			break;
		case "list":
			setMessage(prepare(persistence.list(), "hunger game style"));
			break;
		default:
			return false;
		}
		return true;
	}

	@Override
	public String getEditCommands() {
		StringBuilder builder = new StringBuilder("Unknown command\r\n");
		builder.append("center - to set the center of the spawn\r\n")
				.append("dimension - to set the dimension of the spawn\r\n")
				.append("name - to set the name of the spawn\r\n").append("set - to change the current spawn\r\n")
				.append("new - to create a new spawn\r\n").append("current - to show the current spawn's name\r\n")
				.append("launch - to launch the spawn in the world\r\n").append("save - to save the current spawn\r\n")
				.append("remove - to remove the current spawn from the world\r\n")
				.append("list - to list existing spawns\r\n");
		return builder.toString();
	}

	protected Spawn getSpawn() {
		return persistence.get();
	}

	private void setCenter(String[] args) {
		try {
			getSpawn().setCenter(args[1], args[2], args[3]);
			setMessage("New center : " + args[1] + " " + args[2] + " " + args[3] + " defined");
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define center's coordinates\nNeed three dimensions coordinates (X Y Z)");
		}
	}

	private void setDimension(String[] args) {
		try {
			getSpawn().setDimension(args[1], args[2], args[3]);
			setMessage("New dimensions : " + args[1] + " " + args[2] + " " + args[3] + " defined");
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define spawn's dimension\nNeed three dimensions (X Y Z)");
		}
	}

	private void setName(String[] args) {
		try {
			if (persistence.exist(args[1]))
				setMessage("A spawn with name " + args[1] + " already exist");
			else {
				String oldName = getSpawn().getName();
				getSpawn().setName(args[1]);
				setMessage("Spawn " + oldName + " renamed " + args[1]);
			}
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the spawn's name\nNeed the name");
		}
	}

	private void newSpawn(String[] args) {
		try {
			if (persistence.exist(args[1]))
				setMessage("A spawn with name " + args[1] + " already exist");
			else {
				persistence.save();
				persistence.set(new Spawn(args[1]));
				setMessage("New spawn " + getSpawn().getName() + " created");
			}
		} catch (IndexOutOfBoundsException e) {
			setMessage("Impossible to define the new spawn's name\nNeed the name");
		}
	}

	private void launch(String[] args) {
		if (args.length < 2) {
			getSpawn().launch();
			setMessage("Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter()));
		} else if (args.length < 3) {
			persistence.save();
			try {
				persistence.load(args[1]);
				getSpawn().launch();
				setMessage("Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter()));
			} catch (FileNotFoundException e) {
				setMessage(e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				setMessage("Impossible to launch the new spawn\nNeed the name");
			}
		} else if (args.length < 5) {
			try {
			getSpawn().setCenter(args[1], args[2], args[3]);
			getSpawn().launch();
			setMessage("Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter()));
			} catch (IndexOutOfBoundsException e) {
				setMessage("Impossible to launch " + getSpawn().getName() + " at the specified coordinates");
			}
		} else if (args.length < 6) {
			persistence.save();
			try {
				persistence.load(args[2]);
				getSpawn().setCenter(args[3], args[4], args[5]);
				getSpawn().launch();
				setMessage("Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter()));
			} catch (FileNotFoundException e) {
				setMessage(e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				setMessage("Impossible to launch the new spawn\nNeed the name");
			}
		}
	}
	
	private String showBlock(Block block) {
		return block.getX() + " " + block.getY() + " " + block.getZ();
	}
}
