package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public class CommonHelp<T extends IUnmodifiableName> extends AbstractMapEdition<T> {
	private IEditConfiguration<T> conf;

	public CommonHelp(IEditConfiguration<T> conf) {
		super("help", "to display all features");
		this.conf = conf;
	}

	@Override
	public String edit(String[] args) {
		try {
			IMapEdition<T> edition = conf.getEditions().get(args[0]);
			for (int i = 1; i < args.length; i++)
				if (edition != null)
					edition = edition.getEditions().get(args[i]);
			return edition.help();
		} catch (IndexOutOfBoundsException e) {

		}
		return conf.help();
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
			IMapEdition<T> edition = conf.getEditions().get(args[0]);
			for (int i = 1; i < args.length; i++) {
				edition = edition.getEditions().get(args[i]);
			}
			return filter(edition.getEditions().values().stream().filter(e -> e.isAvailable()).map(e -> e.getLabel()).collect(Collectors.toList()), args[args.length - 1]);
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			return emptyList();
		}
	}
}
