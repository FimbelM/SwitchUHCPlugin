package fr.pederobien.uhc.interfaces;

import java.util.HashMap;

import fr.pederobien.uhc.managers.ETeam;

public interface IBase extends IBawn, IUnmodifiableBase, Cloneable {

	void setChests(HashMap<ISerializableBlock, ETeam> chests);

	Object clone() throws CloneNotSupportedException;
}
