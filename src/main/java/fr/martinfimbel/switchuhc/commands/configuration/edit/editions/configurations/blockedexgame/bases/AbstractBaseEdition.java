package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;
import fr.martinfimbel.switchuhc.managers.BaseManager;

public abstract class AbstractBaseEdition extends AbstractMapEdition<IBlockedexConfiguration> {

	public AbstractBaseEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}

	protected abstract void setBase(String baseName);

	protected abstract void onBaseSetted();

	@Override
	public void edit(String[] args) {
		String name;
		try {
			name = args[0];
			if (BaseManager.checkBaseAvailable(name, get().getTeams())) {
				setBase(name);
				onBaseSetted();
				return;
			}
			sendMessage(MessageCode.BASE_BLOCKEDEX_GAME_DOES_NOT_SUPPORT_TEAM);
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.BASE_BLOCKEDEX_GAME_MISSING_NAME);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(BaseManager.availableBasesAccordingTeam(get().getTeams()), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}
}
