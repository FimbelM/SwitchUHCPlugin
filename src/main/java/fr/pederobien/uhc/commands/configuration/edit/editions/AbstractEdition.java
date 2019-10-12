package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.pederobien.uhc.conf.IUnmodifiableName;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public abstract class AbstractEdition<T extends IUnmodifiableName> implements IEdition {
	private IPersistence<T> persistence;

	public AbstractEdition(IPersistence<T> persistence) {
		this.persistence = persistence;
	}

	protected IPersistence<T> getPersistence() {
		return persistence;
	}

	protected T getConf() {
		return persistence.get();
	}

	protected List<String> filter(Collection<String> list, String filter) {
		Predicate<String> match = str -> str.matches(filter + "(.*)");
		return list.stream().filter(match).collect(Collectors.toList());
	}
}
