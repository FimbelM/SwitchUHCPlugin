package fr.martinfimbel.switchuhc.observers;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;

public interface IObsPersistence<T extends IUnmodifiableName> {

	void onCurrentChange(T newElt);
}
