package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Save extends AbstractHGEdition {

	public Save(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "save", "to save the current hunger game style");
	}

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return "Style " + getConf().getName() + " saved";
	}
}
