package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonAsCurrent;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public class AsCurrentHungerGame extends CommonAsCurrent<IHungerGameConfiguration> {

	public AsCurrentHungerGame(IPersistence<IHungerGameConfiguration> persistence, IConfigurationContext context) {
		super(persistence, context, "to set the current hunger game style as the current style");
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot set current hunger game style as current style, need the name";
	}

	@Override
	protected String onStyleNotDefined() {
		return "Cannot load hunger game style, style does not exist";
	}

}
