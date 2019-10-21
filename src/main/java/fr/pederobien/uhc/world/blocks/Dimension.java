package fr.pederobien.uhc.world.blocks;

import fr.pederobien.uhc.interfaces.IDimension;

public class Dimension implements IDimension {
	private int width, height, depth;
	
	public Dimension() {
		this(0, 0, 0);
	}

	public Dimension(String width, String height, String depth) {
		this(Integer.parseInt(width), Integer.parseInt(height), Integer.parseInt(depth));
	}

	public Dimension(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	public void setDepth(int depth) {
		this.depth = depth;
	}
}
