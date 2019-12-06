package fr.pederobien.uhc.interfaces;

import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.observers.IObsMessageCodeSender;
import fr.pederobien.uhc.observers.IObsPersistence;

public interface IEditConfiguration<T extends IUnmodifiableName> extends IPersistenceEdition<T>, IAvailableEdition<IEditConfiguration<T>>,
		INodeEdition<IMapEdition<T>, IEditConfiguration<T>>, IMessageSender<IEditConfiguration<T>>, IObsPersistence<T>, IObsMessageCodeSender {

	void edit(CommandSender sender, String[] args);

	IEditConfiguration<T> setHelper(IHelper<T> helper);
}
