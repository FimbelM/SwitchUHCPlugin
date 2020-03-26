package fr.martinfimbel.switchuhc.interfaces;

import java.util.Map;

import fr.martinfimbel.switchuhc.managers.EColor;

public interface IBase extends IBawn, IUnmodifiableBase {

	void setChests(Map<ISerializableBlock, EColor> chests);
}
