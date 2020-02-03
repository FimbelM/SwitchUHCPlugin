package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.managers.EColor;

public interface IPlayer extends IUnmodifiablePlayer {

	void setColor(EColor color);
}
