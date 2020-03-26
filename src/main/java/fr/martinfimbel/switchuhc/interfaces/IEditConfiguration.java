package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.observers.IObsMessageCodeSender;
import fr.martinfimbel.switchuhc.observers.IObsPersistence;

public interface IEditConfiguration<T extends IUnmodifiableName>
		extends IPersistenceEdition<T>, IAvailableEdition<IEditConfiguration<T>>, IModifiableEdition<IEditConfiguration<T>>,
		INodeEdition<IMapEdition<T>, IEditConfiguration<T>>, IMessageSender<IEditConfiguration<T>>, IObsPersistence<T>, IObsMessageCodeSender {

	void edit(CommandSender sender, String[] args);

	IEditConfiguration<T> setHelper(IHelper<T> helper);
}
