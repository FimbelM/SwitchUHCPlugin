package fr.pederobien.uhc.observers;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public interface IObsPersistence<T extends IUnmodifiableName> {

	void onCurrentChange(T newElt);
}
