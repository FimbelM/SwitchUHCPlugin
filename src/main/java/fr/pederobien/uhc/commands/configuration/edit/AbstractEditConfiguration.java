package fr.pederobien.uhc.commands.configuration.edit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractEditConfiguration<T extends IUnmodifiableName> extends AbstractMapEdition {
	protected IConfigurationContext context;

	public AbstractEditConfiguration(IConfigurationContext context, String label, String explanation) {
		super(label, explanation);
		this.context = context;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		IMapEdition edition = getEditions().get(args[0]);
		if (edition != null)
			return edition.onTabComplete(sender, command, alias, Arrays.copyOfRange(args, 1, args.length));
		return filter(new ArrayList<String>(getEditions().keySet()), args[0]);
	}
}
