package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.IEditConfig;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.BaseManager;
import net.md_5.bungee.api.ChatColor;

public class NorthBaseBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public NorthBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence, IEditConfig conf) {
		super(persistence, "northbase", "to set the base at the north of the spawn");
		addObservers(conf);
	}

	@Override
	public String edit(String[] args) {
		if (BaseManager.checkBaseAvailable(args[0])) {
			get().setNorthBase(args[0]);
			return "Base " + get().getNorthBase() + " defined as the north base";
		}
		return "Base does not support all team (number or color)";
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			List<String> bases = BaseManager.availableBasesAccordingTeam();
			if (bases.size() == 0)
				sendMessageToSender(ChatColor.RED + "No existing bases that supports team (number or color)");
			return filter(bases, subArguments[0]);
		default:
			return emptyList();
		}
	}
}
