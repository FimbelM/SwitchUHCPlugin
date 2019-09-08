package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.io.FileNotFoundException;

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
			return "Cannot load hunger game style, style does not exist";
		}
	}
}
