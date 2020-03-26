package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.managers.EColor;

public interface ITeam extends IUnmodifiableTeam, IName {

	void setColor(EColor color);

	void addPlayer(Player player);

	void removePlayer(Player player);

	void clear();

	void setCreatedOnServer(boolean createdOnServer);
}
