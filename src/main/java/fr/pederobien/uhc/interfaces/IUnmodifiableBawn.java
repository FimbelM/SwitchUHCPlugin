package fr.pederobien.uhc.interfaces;

import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.observer.IObsBawn;

public interface IUnmodifiableBawn extends IUnmodifiableName {

	void extract();

	void launch();

	void remove();

	List<ISerializableBlock> getBlocks();

	Block getCenter();

	IUnmodifiableDimension getDimension();

	int getWidth();

	int getHeight();

	int getDepth();
	
	void addObserver(IObsBawn obs);
	
	void removeObserver(IObsBawn obs);
}
