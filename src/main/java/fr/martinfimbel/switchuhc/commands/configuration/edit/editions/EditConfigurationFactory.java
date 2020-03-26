package fr.martinfimbel.switchuhc.commands.configuration.edit.editions;

import fr.martinfimbel.switchuhc.commands.configuration.edit.EditBaseConfiguration;
import fr.martinfimbel.switchuhc.commands.configuration.edit.EditBlockedexConfiguration;
import fr.martinfimbel.switchuhc.commands.configuration.edit.EditHungerGameConfiguration;
import fr.martinfimbel.switchuhc.commands.configuration.edit.EditSpawnConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IBase;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.IEditConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class EditConfigurationFactory {
	private static IEditConfiguration<IBase> editBaseConfiguration;
	private static IEditConfiguration<ISpawn> editSpawnConfiguration;
	private static IEditConfiguration<IHungerGameConfiguration> editHungerGameConfiguration;
	private static IEditConfiguration<IBlockedexConfiguration> editBlockedexConfiguration;

	public synchronized static IEditConfiguration<IBase> getEditBaseConfiguration() {
		if (editBaseConfiguration == null)
			editBaseConfiguration = new EditBaseConfiguration();
		return editBaseConfiguration;
	}

	public synchronized static IEditConfiguration<ISpawn> getEditSpawnConfiguration() {
		if (editSpawnConfiguration == null)
			editSpawnConfiguration = new EditSpawnConfiguration();
		return editSpawnConfiguration;
	}

	public synchronized static IEditConfiguration<IHungerGameConfiguration> getEditHungerGameConfiguration(IConfigurationContext context) {
		if (editHungerGameConfiguration == null)
			editHungerGameConfiguration = new EditHungerGameConfiguration(context);
		return editHungerGameConfiguration;
	}

	public synchronized static IEditConfiguration<IBlockedexConfiguration> getEditBlockedexConfiguration(IConfigurationContext context) {
		if (editBlockedexConfiguration == null)
			editBlockedexConfiguration = new EditBlockedexConfiguration(context);
		return editBlockedexConfiguration;
	}

	public static void setAllAvailable(boolean available) {
		editBaseConfiguration.setAvailable(available);
		editSpawnConfiguration.setAvailable(available);
		editHungerGameConfiguration.setAvailable(available);
		editBlockedexConfiguration.setAvailable(available);
	}
}
