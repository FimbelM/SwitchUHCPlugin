package fr.pederobien.uhc.conf.persistence;

import fr.pederobien.uhc.conf.Spawn;

public class SpawnPersistence extends AbstractPersistence<Spawn> {
	protected static final String SPAWNS = ROOT + "Spawns/";
	
	private Spawn spawn;
	
	public SpawnPersistence(Spawn spawn) {
		setSpawn(spawn);
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
	
	public String getSpawnsName() {
		return null;
	}

	@Override
	public void save() {
		String xml = openingTag("spawn");
		xml += openingTabTag(1, "center");
		xml += tabAttribut(2, "x", Integer.toString(spawn.getCenter().getX()));
		xml += tabAttribut(2, "y", Integer.toString(spawn.getCenter().getY()));
		xml += tabAttribut(2, "z", Integer.toString(spawn.getCenter().getZ()));
		xml += openingTabTag(1, "blocks");
		for (String block : spawn.getBlocks()) {
			String[] info = block.split(";");
			xml += tabAttribut(2, "x", info[0]);
			xml += tabAttribut(2, "y", info[1]);
			xml += tabAttribut(2, "z", info[2]);
			xml += tabAttribut(2, "material", info[3]);
		}
		xml += closingTabTag(1, "blocks");
		xml += closingTag("spawn");
		write(SPAWNS + spawn.getName() + ".xml", xml);
	}
}
