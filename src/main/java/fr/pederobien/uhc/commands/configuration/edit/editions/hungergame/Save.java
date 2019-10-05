package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class Save extends AbstractHGEdition {

	public Save(HungerGamePersistence persistence) {
		super(persistence, HGEditions.SAVE);
	}

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return "Configuration " + getConf().getName() + " saved";
	}
}
