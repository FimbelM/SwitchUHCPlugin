package fr.pederobien.uhc.commands.configuration.edit.editions;

import fr.pederobien.uhc.commands.configuration.edit.EditBaseConfiguration;
import fr.pederobien.uhc.commands.configuration.edit.EditBlockedexConfiguration;
import fr.pederobien.uhc.commands.configuration.edit.EditHungerGameConfiguration;
import fr.pederobien.uhc.commands.configuration.edit.EditSpawnConfiguration;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.interfaces.ISpawn;

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
