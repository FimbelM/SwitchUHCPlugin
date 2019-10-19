package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractEdition<T extends IUnmodifiableName> extends AbstractMapEdition {
	private IPersistence<T> persistence;

	public AbstractEdition(IPersistence<T> persistence, String label, String explanation) {
		super(label, explanation);
		this.persistence = persistence;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return emptyList();
	}

	protected IPersistence<T> getPersistence() {
		return persistence;
	}

	protected T get() {
		return persistence.get();
	}
}
