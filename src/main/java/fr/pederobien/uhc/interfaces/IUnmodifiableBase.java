package fr.pederobien.uhc.interfaces;

import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.event.PlayerInteractEventResponse;
import fr.pederobien.uhc.managers.ETeam;

public interface IUnmodifiableBase extends IUnmodifiableBawn {
	
	Map<ISerializableBlock, ETeam> getChests();

	PlayerInteractEventResponse isChestRestricted(Block block, Player player);
	
	int getChestsNumber();
}
