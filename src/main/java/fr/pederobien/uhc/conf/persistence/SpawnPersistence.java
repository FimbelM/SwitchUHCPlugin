package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.Spawn;

public class SpawnPersistence extends AbstractPersistence<Spawn> {
	protected static final String SPAWNS = ROOT + "Spawns/";

	private Spawn spawn;

	public SpawnPersistence(Spawn spawn) {
		setSpawn(spawn);
		checkAndWriteDefault(SPAWNS, Spawn.DEFAULT);
	}

	public Spawn getSpawn() {
		return spawn;
	}

	public void setSpawn(Spawn spawn) {
		this.spawn = spawn;
	}
	
	@Override
	public void load(String name) throws FileNotFoundException {
		
	}

	@Override
	public void save(Spawn toSave) {

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

	public String getSpawnsName() {
		return null;
	}
}
