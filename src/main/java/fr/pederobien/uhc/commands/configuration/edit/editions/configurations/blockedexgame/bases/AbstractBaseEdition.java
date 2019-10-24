package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.BaseManager;
import net.md_5.bungee.api.ChatColor;

public abstract class AbstractBaseEdition extends AbstractEdition<IBlockedexConfiguration> {

	public AbstractBaseEdition(IPersistence<IBlockedexConfiguration> persistence, String label, String explanation) {
		super(persistence, label, explanation);
	}

	protected abstract void setBase(String baseName);

	protected abstract String onBaseSetted();

	@Override
	public String edit(String[] args) {
		String name;
		try {
			name = args[0];
			if (BaseManager.checkBaseAvailable(name, get().getTeams())) {
				setBase(name);
				return onBaseSetted();
			}
			return "Base does not support all team (number or color)";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set base, need the name";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1) {
			List<String> bases = BaseManager.availableBasesAccordingTeam(get().getTeams());
			if (bases.size() == 0)
				sendMessageToSender(sender, ChatColor.RED + "No existing bases that supports team (number or color)");
			return filter(bases, args[0]);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
