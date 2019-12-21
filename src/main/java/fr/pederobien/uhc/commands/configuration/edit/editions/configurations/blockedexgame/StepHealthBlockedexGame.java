package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class StepHealthBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public StepHealthBlockedexGame() {
		super("stephealth", MessageCode.STEP_HEALTH_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		double step;
		try {
			step = Double.parseDouble(args[0]);
			if (step <= 0) {
				sendMessage(MessageCode.STEP_HEALTH_BLOCKEDEX_GAME_NEGATIVE_STEP);
				return;
			}

			get().setStepOnMaxHealth(step);
			sendMessage(MessageCode.STEP_HEALTH_BLOCKEDEX_GAME_STEP_DEFINED, get().getStepOnMaxHealth().toString());
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.STEP_HEALTH_BLOCKEDEX_GAME_BAD_STEP_FORMAT);
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.STEP_HEALTH_BLOCKEDEX_GAME_MISSING_STEP);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.STEP_HEALTH_BLOCKEDEX_GAME_ON_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
