package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.managers.BaseManager;
import net.md_5.bungee.api.ChatColor;

public abstract class CommonBaseBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	protected CommonBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence, String label, String explanation) {
		super(persistence, label, explanation);
	}

	protected abstract void setBase(IUnmodifiableBase base);

	protected abstract String onBaseSetted();

	@Override
	public String edit(String[] args) {
		String name;
		try {
			name = args[0];
			if (BaseManager.checkBaseAvailable(name)) {
				setBase(BaseManager.getBaseByName(name));
				return onBaseSetted();
			}
			return "Base does not support all team (number or color)";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set base, need the name";
		}
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
