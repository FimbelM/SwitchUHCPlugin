package fr.pederobien.uhc.persistence.loader;

import org.w3c.dom.Node;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public interface IPersistenceLoader<T extends IUnmodifiableName> {
	
	String getVersion();

	IPersistenceLoader<T> load(Node root);

	T get();
}
