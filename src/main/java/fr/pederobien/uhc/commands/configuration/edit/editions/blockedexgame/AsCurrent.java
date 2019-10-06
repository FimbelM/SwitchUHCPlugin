package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.io.FileNotFoundException;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;

public class AsCurrent extends AbstractBDEdition {
	private IConfigurationContext context;

	public AsCurrent(BlockedexPersistence persistence, IConfigurationContext context) {
		super(persistence, BDEditions.AS_CURRENT);
		this.context = context;
	}

	@Override
	public String edit(String[] args) {
		if (args.length == 0) {
			context.setCurrentConfiguration(getPersistence().get());
			return "Game " + getConf().getName() + " defined as current configuration";
		} else {
			getPersistence().save();
			try {
				getPersistence().load(args[0]);
				context.setCurrentConfiguration(getConf());
				return "Game " + getConf().getName() + " defined as current configuration";
			} catch (IndexOutOfBoundsException e) {
				return "Cannot set current hunger game style as current configuration, need the name";
			} catch (FileNotFoundException e) {
				return "Cannot load hunger game style, style does not exist";
			}
		}
	}
}
