package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class RadiusAreaOnPlayerDieBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public RadiusAreaOnPlayerDieBlockedexGame() {
		super("radiusareaonplayerdie", MessageCode.RADIUS_AREA_ON_PLAYER_DIE_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		int distance;
		try {
			distance = Integer.parseInt(args[0]);
			if (distance < 0) {
				sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_DIE_BLOCKEDEX_GAME_NEGATIVE_DISTANCE);
				return;
			}

			get().setRadiusAreaOnPlayerDie(distance);
			sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_DIE_BLOCKEDEX_GAME_RADIUS_DEFINED, get().getRadiusAreaOnPlayerDie().toString());
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_DIE_BLOCKEDEX_GAME_BAD_DISTANCE_FORMAT);
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_DIE_BLOCKEDEX_GAME_MISSING_DISTANCE);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.RADIUS_AREA_ON_PLAYER_DIE_BLOCKEDEX_GAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
