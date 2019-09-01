package fr.pederobien.uhc.commands.configuration.edit;

import java.io.FileNotFoundException;

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
		try {
			switch (args[0]) {
			case "center":
				getSpawn().setCenter(args[1], args[2], args[3]);
				setMessage("New center : " + args[1] + " " + args[2] + " " + args[3]);
				break;
			case "dimension":
				getSpawn().setDimension(args[1], args[2], args[3]);
				setMessage("New dimension : " + args[1] + " " + args[2] + " " + args[3]);
				break;
			case "width":
				getSpawn().setWidth(Integer.parseInt(args[1]));
				setMessage("New width : " + args[1]);
				break;
			case "height":
				getSpawn().setHeight(Integer.parseInt(args[1]));
				setMessage("New height : " + args[1]);
				break;
			case "depth":
				getSpawn().setDepth(Integer.parseInt(args[1]));
				setMessage("New depth : " + args[1]);
				break;
			case "name":
				if (persistence.exist(args[1])) {
					if (args.length == 2)
						setMessage("A spawn with name " + args[1] + " already exist\nIf you want to overrite it add -f");
					else if (args.length == 3 && args[2].equals("-f")) {
						persistence.delete(args[1]);
						persistence.delete(getSpawn().getName());
						getSpawn().setName(args[1]);
						persistence.save();
						setMessage("New name : " + args[1]);
					}
				} else {
					getSpawn().setName(args[1]);
					setMessage("New name : " + args[1]);
				}
				break;
			case "set":
				persistence.save();
				persistence.load(args[1]);
				setMessage("New spawn " + getSpawn().getName());
				break;
			case "new":
				if (persistence.exist(args[1]))
					setMessage("A spawn with name " + args[1] + " already exist");
				else {
					persistence.save();
					persistence.set(new Spawn(args[1]));
					setMessage("New spawn " + getSpawn().getName() + " created");
				}
				break;
			case "ascurrent":
				if (args.length == 0) {
					context.setSpawn(persistence.get());
					getSpawn().launch();
					setMessage("Spawn " + getSpawn().getName() + " defined as current spawn for the configuration " + context.getName());
				} else {
					persistence.save();
					try {
						persistence.load(args[0]);
						context.setSpawn(getSpawn());
						getSpawn().launch();
						setMessage("Spawn " + getSpawn().getName() + " defined as current spawn for the configuration " + context.getName());
					} catch (FileNotFoundException e) {
						setMessage("Spawn " + args[0] + " does not exist");
					}
				}
				break;
			case "save":
				persistence.save();
				setMessage("Spawn " + getSpawn().getName() + " saved");
				break;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	protected Spawn getSpawn() {
		return persistence.get();
	}
}
