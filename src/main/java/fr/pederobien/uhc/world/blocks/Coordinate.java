package fr.pederobien.uhc.world.blocks;

public class Coordinate {
	private int x, y, z;

	public Coordinate(int x, int y, int z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;
		Coordinate coord = (Coordinate) obj;
		return x == coord.getX() && y == coord.getY() && z == coord.getZ();
	}
	
	@Override
	public String toString() {
		return "{Coordinate{x=" + x + ",y=" + y + ",z=" + z + "}}";
	}
}
