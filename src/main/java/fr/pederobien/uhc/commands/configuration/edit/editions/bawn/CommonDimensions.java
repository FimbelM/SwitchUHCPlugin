package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.world.blocks.Dimension;

public abstract class CommonDimensions<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonDimensions(IMessageCode explanation) {
		super("dimensions", explanation);
	}

	protected abstract void dimensionsDefined(int width, int height, int depth);

	@Override
	public void edit(String[] args) {
		try {
			get().setDimension(new Dimension(args[0], args[1], args[2]));
			dimensionsDefined(get().getWidth(), get().getHeight(), get().getDepth());
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.DIMENSIONS_MISSING_DIMENSIONS);
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.DIMENSIONS_BAD_DIMENSIONS_FORMAT);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList(onTabComplete(sender, MessageCode.DIMENSIONS_WITDH_HEIGHT_DEPTH_TAB_COMPLETE));
		case 2:
			return Arrays.asList(onTabComplete(sender, MessageCode.DIMENSIONS_HEIGHT_DEPTH_TAB_COMPLETE));
		case 3:
			return Arrays.asList(onTabComplete(sender, MessageCode.DIMENSIONS_DEPTH_TAB_COMPLETE));
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
