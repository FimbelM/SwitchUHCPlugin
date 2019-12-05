package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class BorderCenterHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public BorderCenterHungerGame() {
		super("bordercenter", MessageCode.BORDER_CENTER_HUNGER_GAME_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		try {
			get().setBorderCenter(args[0], args[1]);
			return MessageCode.BORDER_CENTER_HUNGER_GAME_DEFINED.withArgs("" + get().getBorderCenter().getX(), "" + get().getBorderCenter().getZ());
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			return MessageCode.BORDER_CENTER_HUNGER_GAME_MISSING_COORDINATES;
		} catch (NumberFormatException e) {
			return MessageCode.BORDER_CENTER_HUNGER_GAME_BAD_COORDINATES_FORMAT;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList("<X> <Z>");
		case 2:
			return Arrays.asList("<Z>");
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
