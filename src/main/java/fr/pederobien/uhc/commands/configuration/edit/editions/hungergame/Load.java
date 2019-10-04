package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.io.FileNotFoundException;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class Load extends AbstractHGEdition {

	public Load(HungerGamePersistence persistence) {
		super(persistence, HGEditions.LOAD);
	}

	@Override
	public String edit(String[] args) {
		try {
			getPersistence().save();
			getPersistence().load(args[1]);
			return "New configuration " + getPersistence().get().getName() + " loaded";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot load hunger game style, need the name";
		} catch (FileNotFoundException e) {
			return "Cannot load style " + args[1] + ", style does not exist";
		}
	}
	
	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return filter(getPersistence().list(), subArguments[0]);
		default:
			return null;
		}
	}
}
