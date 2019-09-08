package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.io.FileNotFoundException;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class AsCurrent extends AbstractHGEdition {
	private ConfigurationContext context;

	public AsCurrent(HungerGamePersistence persistence, ConfigurationContext context) {
		super(persistence, HGEditions.AS_CURRENT);
		this.context = context;
	}

	@Override
	public String edit(String[] args) {
		if (args.length == 1) {
			context.setCurrentConfiguration(getPersistence().get());
			return "Game " + getConf().getName() + " defined as current configuration";
		} else {
			getPersistence().save();
			try {
				getPersistence().load(args[1]);
				context.setCurrentConfiguration(getConf());
				return getConf().getName() + " defined as current configuration";
			} catch (IndexOutOfBoundsException e) {
				return "Cannot set current hunger game style as current configuration, need the name";
			} catch (FileNotFoundException e) {
				return "Cannot load hunger game style, style does not exist";
			}
		}
	}
}
