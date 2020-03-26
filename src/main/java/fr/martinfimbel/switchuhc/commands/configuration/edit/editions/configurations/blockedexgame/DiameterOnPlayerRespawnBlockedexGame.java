package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class DiameterOnPlayerRespawnBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public DiameterOnPlayerRespawnBlockedexGame() {
		super("playerrespawnareadiameter", MessageCode.PLAYER_RESPAWN_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		int diameter;
		try {
			diameter = Integer.parseInt(args[0]);
			if (diameter <= 0) {
				sendMessage(MessageCode.PLAYER_RESPAWN_BLOCKEDEX_GAME_NEGATIVE_DIAMETER);
				return;
			}

			get().setDiameterAreaOnPlayerRespawn(diameter);
			sendMessage(MessageCode.PLAYER_RESPAWN_BLOCKEDEX_GAME_DIAMETER_DEFINED, get().getDiameterAreaOnPlayerRespawn().toString());
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.PLAYER_RESPAWN_BLOCKEDEX_GAME_BAD_DIAMETER_FORMAT);
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.PLAYER_RESPAWN_BLOCKEDEX_GAME_MISSING_DIAMETER);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.PLAYER_RESPAWN_BLOCKEDEX_GAME_ON_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}

}
