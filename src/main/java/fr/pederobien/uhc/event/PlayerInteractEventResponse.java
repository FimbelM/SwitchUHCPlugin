package fr.pederobien.uhc.event;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.managers.ETeam;

public class PlayerInteractEventResponse {
	private boolean restricted;
	private ETeam teamAllowed;
	private Block chest;
	private Player player;
	
	public PlayerInteractEventResponse(boolean restricted, ETeam teamAllowed, Block chest, Player player) {
		this.restricted = restricted;
		this.teamAllowed = teamAllowed;
		this.chest = chest;
		this.player = player;
	}
	
	public boolean isChestRestricted() {
		return restricted;
	}
	
	public ETeam getTeamAllowed() {
		return teamAllowed;
	}
	
	public Block getBlock() {
		return chest;
	}
	
	public Player getPlayer() {
		return player;
	}
}
