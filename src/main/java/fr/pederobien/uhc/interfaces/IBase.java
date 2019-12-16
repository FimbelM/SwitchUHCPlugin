package fr.pederobien.uhc.interfaces;

import java.util.HashMap;

import fr.pederobien.uhc.managers.EColor;

public interface IBase extends IBawn, IUnmodifiableBase, Cloneable {

	void setChests(HashMap<ISerializableBlock, EColor> chests);

	Object clone() throws CloneNotSupportedException;
}
