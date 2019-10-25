package fr.pederobien.uhc.observer;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public interface IObsPersistence<T extends IUnmodifiableName> {
	
	void onCurrentChange(T newElt);
}
