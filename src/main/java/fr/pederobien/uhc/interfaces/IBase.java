package fr.pederobien.uhc.interfaces;

import java.util.Map;

import fr.pederobien.uhc.managers.EColor;

public interface IBase extends IBawn, IUnmodifiableBase {

	void setChests(Map<ISerializableBlock, EColor> chests);
}
