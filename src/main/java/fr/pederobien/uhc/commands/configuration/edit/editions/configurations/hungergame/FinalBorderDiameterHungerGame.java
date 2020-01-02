package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class FinalBorderDiameterHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public FinalBorderDiameterHungerGame() {
		super("finalborderdiameter", MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			int diameter = Integer.parseInt(args[0]);
			if (diameter <= 0) {
				sendMessage(MessageCode.FINAL_BORDER_NEGATIVE_DIAMETER);
				return;
			}

			get().setFinalBorderDiameter(diameter);
			sendMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_DEFINED, get().getFinalBorderDiameter().toString());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_MISSING_DIAMETER);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_BAD_DIAMETER_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.FINAL_BORDER_DIAMETER_HUNGER_GAME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
