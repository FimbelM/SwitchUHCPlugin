package fr.pederobien.uhc.interfaces;

import org.bukkit.entity.Player;

import fr.pederobien.uhc.managers.EColor;

public interface ITeam extends IUnmodifiableTeam, IName {

	void setColor(EColor color);

	void addPlayer(Player player);

	void removePlayer(Player player);

	void clear();
}
