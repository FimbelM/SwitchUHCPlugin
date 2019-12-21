package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class RadiusAreaOnPlayerKillBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public RadiusAreaOnPlayerKillBlockedexGame() {
		super("radiusareaonplayerkill", MessageCode.RADIUS_AREA_ON_PLAYER_KILL_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		int distance;
		try {
			distance = Integer.parseInt(args[0]);
			if (distance < 0) {
				sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_KILL_BLOCKEDEX_GAME_NEGATIVE_DISTANCE);
				return;
			}

			get().setRadiusAreaOnPlayerDie(distance);
			sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_KILL_BLOCKEDEX_GAME_RADIUS_DEFINED, get().getRadiusAreaOnPlayerDie().toString());
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_KILL_BLOCKEDEX_GAME_BAD_DISTANCE_FORMAT);
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.RADIUS_AREA_ON_PLAYER_KILL_BLOCKEDEX_GAME_MISSING_DISTANCE);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.RADIUS_AREA_ON_PLAYER_KILL_BLOCKEDEX_GAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
