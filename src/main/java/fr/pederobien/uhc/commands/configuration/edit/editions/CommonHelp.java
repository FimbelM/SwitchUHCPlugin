package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public class CommonHelp extends AbstractEdition<IUnmodifiableName> {
	private IMapEdition conf;

	public CommonHelp(IMapEdition conf) {
		super(null, "help", "to display all features");
		this.conf = conf;
	}

	@Override
	public String edit(String[] args) {
		try {
			for (IMapEdition edition : conf.getEditions().values())
				if (edition.getLabel().equals(args[0]))
					return edition.help();
		} catch (IndexOutOfBoundsException e) {

		}
		return conf.help();
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(conf.getEditions().keySet(), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}
}
