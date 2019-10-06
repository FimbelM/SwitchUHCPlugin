package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;

public class Current extends AbstractBDEdition {

	public Current(BlockedexPersistence persistence) {
		super(persistence, BDEditions.CURRENT);
	}

	@Override
	public String edit(String[] args) {
		return "Current blockedex game style " + getConf().getName();
	}
}
