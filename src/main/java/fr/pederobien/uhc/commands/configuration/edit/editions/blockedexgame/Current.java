package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Current extends AbstractBDEdition {

	public Current(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, BDEditions.CURRENT);
	}

	@Override
	public String edit(String[] args) {
		return "Current blockedex game style " + getConf().getName();
	}
}
