package fr.pederobien.uhc.commands.configuration.edit;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.dictionary.DictionaryManager;
import fr.pederobien.uhc.dictionary.NotificationCenter;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IHelper;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.INodeEdition;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public class Helper<T extends IUnmodifiableName> extends AbstractEdition implements IHelper<T> {
	private IEditConfiguration<T> configuration;

	public Helper(IEditConfiguration<T> configuration) {
		super("help", MessageCode.HELP_EXPLANATION);
		this.configuration = configuration;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		try {
			Collection<IMapEdition<T>> values = configuration.getChildren().values();

			IMapEdition<T> edition = configuration.getChildren().get(args[0]);
			for (int i = 1; i < args.length; i++) {
				if (edition != null) {
					values = edition.getChildren().values();
					edition = edition.getChildren().get(args[i]);
				}
			}
			return filter(filterValues(values), args[args.length - 1]);
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			return emptyList();
		}
	}

	@Override
	public IHelper<T> setConfig(IEditConfiguration<T> configuration) {
		this.configuration = configuration;
		return this;
	}

	@Override
	public String edit(CommandSender sender, String[] args) {
		try {
			IMapEdition<T> edition = configuration.getChildren().get(args[0]);
			for (int i = 1; i < args.length; i++)
				if (edition != null)
					edition = edition.getChildren().get(args[i]);
			return translate(sender, edition);
		} catch (IndexOutOfBoundsException e) {
			return translate(sender, configuration);
		}
	}

	private Stream<String> filterValues(Collection<IMapEdition<T>> values) {
		return values.stream().filter(e -> e.isAvailable()).filter(e -> !e.getLabel().equals("help"))
				.map(e -> e.getLabel());
	}

	private <U> String translate(CommandSender sender, INodeEdition<IMapEdition<T>, U> edition) {
		String translation = help(sender, edition);
		for (IMapEdition<T> e : edition.getChildren().values())
			translation += help(sender, e);
		return translation;
	}

	private <U> String help(CommandSender sender, INodeEdition<IMapEdition<T>, U> edition) {
		String explanation = DictionaryManager.getMessage(NotificationCenter.getLocale((Player) sender),
				EventFactory.createMessageCodeEvent(edition.getExplanation()));
		return ChatColor.DARK_RED + edition.getLabel() + " - " + ChatColor.DARK_AQUA + explanation + "\n";
	}
}
