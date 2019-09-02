package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.util.List;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.Spawn.Coordinate;

public class SpawnPersistence extends AbstractPersistence<Spawn> {
	protected static final String SPAWNS = ROOT + "Spawns/";
	private Spawn spawn;

	public SpawnPersistence() {
		set(Spawn.DEFAULT);
		checkAndWriteDefault(SPAWNS, get());
	}
	
	@Override
	public boolean exist(String name) {
		return super.exist(SPAWNS + name + ".xml");
	}

	@Override
	public void load(String name) throws FileNotFoundException {
		if (!exist(name))
			throw new FileNotFoundException("Cannot find spawn named " + name);
	}

	@Override
	public void save() {
		StringBuilder builder = new StringBuilder();

		builder.append(openingTag("spawn")).append(attribut(1, "name", spawn.getName()))
				.append(openingTabTag(1, "center")).append(attribut(2, "x", spawn.getCenter().getX()))
				.append(attribut(2, "y", spawn.getCenter().getY())).append(attribut(2, "z", spawn.getCenter().getZ()))
				.append(openingTabTag(1, "blocks"));
		for (Coordinate coord : spawn.getBlocks().keySet()) {
			builder.append(openingTabTag(2, "block")).append(attribut(3, "x", coord.getX()))
					.append(attribut(3, "y", coord.getY())).append(attribut(3, "z", coord.getZ()))
					.append(attribut(3, "material", spawn.getBlocks().get(coord))).append(closingTabTag(2, "block"));
		}
		builder.append(closingTabTag(1, "blocks")).append(closingTag("spawn"));
		write(SPAWNS + spawn.getName() + ".xml", builder.toString());
	}

	@Override
	public Spawn get() {
		return spawn;
	}

	@Override
	public void set(Spawn spawn) {
		this.spawn = spawn;
	}

	@Override
	public List<String> list() {
		return getList(SPAWNS);
	}
}
