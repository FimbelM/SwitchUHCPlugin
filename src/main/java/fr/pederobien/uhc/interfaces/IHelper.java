package fr.pederobien.uhc.interfaces;

import org.bukkit.command.CommandSender;

public interface IHelper<T extends IUnmodifiableName> extends IEdition {

	IHelper<T> setConfig(IEditConfiguration<T> configuration);

	void edit(CommandSender sender, String[] args);
}
