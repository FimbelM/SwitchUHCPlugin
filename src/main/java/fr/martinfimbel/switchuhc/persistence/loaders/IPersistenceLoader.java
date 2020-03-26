package fr.martinfimbel.switchuhc.persistence.loaders;

import org.w3c.dom.Node;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;

public interface IPersistenceLoader<T extends IUnmodifiableName> {

	String getVersion();

	IPersistenceLoader<T> load(Node root);

	T get();
}
