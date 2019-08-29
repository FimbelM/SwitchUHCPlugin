package fr.pederobien.uhc.conf.persistence;

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
	public Spawn load(String name) {
		return null;
	}
	
	@Override
	public void save(Spawn toSave) {
		
	}

	@Override
	public void save() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(openingTag("spawn"))
		.append(openingTabTag(1, "center"))
		.append(tabAttribut(2, "x", spawn.getCenter().getX()))
		.append(tabAttribut(2, "y", spawn.getCenter().getY()))
		.append(tabAttribut(2, "z", spawn.getCenter().getZ()))
		.append(openingTabTag(1, "blocks"));
		for (String block : spawn.getBlocks()) {
			String[] info = block.split("");
			builder.append(tabAttribut(2, "x", info[0]))
			.append(tabAttribut(2, "y", info[1]))
			.append(tabAttribut(2, "z", info[2]))
			.append(tabAttribut(2, "material", info[3]));
		}
		builder.append(closingTabTag(1, "blocks"))
		.append(closingTag("spawn"));
		write(SPAWNS + spawn.getName() + ".xml", builder.toString());
	}
	
	public String getSpawnsName() {
		return null;
	}
}
