package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
			Collection<IMapEdition<T>> values = conf.getEditions().values();
			
			IMapEdition<T> edition = conf.getEditions().get(args[0]);
			for (int i = 1; i < args.length; i++) {
				if (edition != null) {
					System.out.println("Edition : " + edition.getLabel());
					values = edition.getEditions().values();
					edition = edition.getEditions().get(args[i]);
				}
			}
			return filter(filterValues(values), args[args.length - 1]);
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			return emptyList();
		}
	}

	private Stream<String> filterValues(Collection<IMapEdition<T>> values) {
		return values.stream().filter(e -> e.isAvailable()).filter(e -> !e.getLabel().equals("help"))
				.map(e -> e.getLabel());
	}
}
