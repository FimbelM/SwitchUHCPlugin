package fr.pederobien.uhc.interfaces;

import java.util.Map;

import org.bukkit.block.Block;

import fr.pederobien.uhc.event.PlayerInteractEventResponse;
import fr.pederobien.uhc.managers.EColor;

public interface IUnmodifiableBase extends IUnmodifiableBawn {

	Map<ISerializableBlock, EColor> getChests();

	PlayerInteractEventResponse isChestRestricted(Block block, EColor team);

	int getChestsNumber();
}
