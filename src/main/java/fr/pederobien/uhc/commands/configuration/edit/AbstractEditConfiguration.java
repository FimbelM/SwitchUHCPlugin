package fr.pederobien.uhc.commands.configuration.edit;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.interfaces.IWithChildEdition;

public class AbstractEditConfiguration<T extends IUnmodifiableName> implements IEditConfiguration<T> {

	public AbstractEditConfiguration(IPersistence<T> persistence, String label, String explanation) {

	}

	@Override
	public String edit(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExplanation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPersistence<T> getPersistence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWithChildEdition<T> addEdition(IMapEdition<T> edition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWithChildEdition<T> removeEdition(IMapEdition<T> edition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAvailable(boolean available) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}
}
