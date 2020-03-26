package fr.martinfimbel.switchuhc.interfaces;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.managers.EColor;

public interface IUnmodifiableTeam extends IUnmodifiableName {

	String getColoredName();

	EColor getColor();

	List<Player> getPlayers();

	List<Player> getPlayersOnMode(GameMode mode);

	boolean isCreatedOnServer();
}
