package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.Spawn;

public class SpawnPersistence extends AbstractPersistence<Spawn> {
	protected static final String SPAWNS = ROOT + "Spawns/";
	private Spawn spawn;

	public SpawnPersistence() {
		set(Spawn.DEFAULT);
		System.out.println("Spawn persistence constructor");
		checkAndWriteDefault(SPAWNS, get());
	}

	@Override
	public void load(String name) throws FileNotFoundException {
		if (!exist(name))
			throw new FileNotFoundException("Cannot find spawn named " + name);
	}

	@Override
	public void save() {
		StringBuilder builder = new StringBuilder();

		builder.append(openingTag("spawn")).append(openingTabTag(1, "center"))
				.append(tabAttribut(2, "x", spawn.getCenter().getX()))
				.append(tabAttribut(2, "y", spawn.getCenter().getY()))
				.append(tabAttribut(2, "z", spawn.getCenter().getZ())).append(openingTabTag(1, "blocks"));
		for (Block block : spawn.getBlocks()) {
			builder.append(tabAttribut(2, "x", block.getX())).append(tabAttribut(2, "y", block.getY()))
					.append(tabAttribut(2, "z", block.getZ())).append(tabAttribut(2, "material", block.getType()));
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

	public String getSpawnsName() {
		return null;
	}
}
