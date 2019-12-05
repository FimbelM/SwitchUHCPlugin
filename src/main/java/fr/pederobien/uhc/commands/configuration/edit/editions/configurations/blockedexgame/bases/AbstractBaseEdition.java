package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.managers.BaseManager;

public abstract class AbstractBaseEdition extends AbstractMapEdition<IBlockedexConfiguration> {

	public AbstractBaseEdition(String label, MessageCode explanation) {
		super(label, explanation);
	}

	protected abstract void setBase(String baseName);

	protected abstract MessageCode onBaseSetted();

	@Override
	public MessageCode edit(String[] args) {
		String name;
		try {
			name = args[0];
			if (BaseManager.checkBaseAvailable(name, get().getTeams())) {
				setBase(name);
				return onBaseSetted();
			}
			return MessageCode.BASE_BLOCKEDEX_GAME_DOES_NOT_SUPPORT_TEAM;
		} catch (IndexOutOfBoundsException e) {
			return MessageCode.BASE_BLOCKEDEX_GAME_MISSING_NAME;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(BaseManager.availableBasesAccordingTeam(get().getTeams()), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}
}
