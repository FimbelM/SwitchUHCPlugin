package fr.pederobien.uhc.commands.configuration.edit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IPersistenceEdition;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.interfaces.IWithChildEdition;
import fr.pederobien.uhc.observers.IObsEditConfiguration;

public abstract class AbstractEditConfiguration<T extends IUnmodifiableName> extends AbstractMapEdition<T>
		implements IEditConfiguration<T> {
	private IPersistence<T> persistence;
	private List<IObsEditConfiguration> observers;

	public AbstractEditConfiguration(IPersistence<T> persistence, String label, String explanation) {
		super(label, explanation);
		this.persistence = persistence;
		this.persistence.addObserver(this);
		
		observers = new ArrayList<IObsEditConfiguration>();
	}
	
	@Override
	public String edit(String[] args) {
		return isAvailable() ? super.edit(args) : "Command " + getLabel() + " not available yet";
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return isAvailable() ? super.onTabComplete(sender, command, alias, args) : emptyList();
		
	}
	
	@Override
	public IWithChildEdition<T> addEdition(IMapEdition<T> edition) {
		return super.addEdition(edition.setAvailable(false));
	}
	
	@Override
	public IPersistenceEdition<T> getParent() {
		return this;
	}

	@Override
	public IPersistence<T> getPersistence() {
		return persistence;
	}

	@Override
	public T get() {
		return persistence.get();
	}

	@Override
	public void onCurrentChange(T newElt) {
		setAllAvailable(newElt != null);
	}
	
	@Override
	public IEditConfiguration<T> addObserver(IObsEditConfiguration obs) {
		observers.add(obs);
		return this;
	}
	
	@Override
	public IEditConfiguration<T> removeObserver(IObsEditConfiguration obs) {
		observers.remove(obs);
		return this;
	}

	private void setAllAvailable(boolean available) {
		for (IMapEdition<T> edition : getEditions().values())
			edition.setAvailable(available);
	}
}
