package fr.martinfimbel.switchuhc.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.martinfimbel.switchuhc.interfaces.ISerializableBlock;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;
import fr.martinfimbel.switchuhc.persistence.loaders.bawn.spawn.SpawnDefaultContent;
import fr.martinfimbel.switchuhc.persistence.loaders.bawn.spawn.SpawnLoaderV10;
import fr.martinfimbel.switchuhc.persistence.loaders.bawn.spawn.SpawnLoaderV11;
import fr.martinfimbel.switchuhc.persistence.loaders.bawn.spawn.SpawnLoaderV12;

public class SpawnPersistence extends AbstractBawnPersistence<ISpawn> {

	public SpawnPersistence() {
		super(new SpawnDefaultContent());

		registerLoader(new SpawnLoaderV10()).registerLoader(new SpawnLoaderV11()).registerLoader(new SpawnLoaderV12());
	}

	private static final double CURRENT_VERSION = 1.2;

	@Override
	protected String getPath() {
		return ROOT + "Spawns/";
	}

	@Override
	protected String onLoadNotFound(String name) {
		return "Cannot find spawn named " + name;
	}

	@Override
	public void save() {
		if (get() == null)
			return;
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = doc.createElement("spawn");
		doc.appendChild(root);

		Element version = doc.createElement("version");
		version.appendChild(doc.createTextNode("" + CURRENT_VERSION));
		root.appendChild(version);

		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

		Element dimensions = doc.createElement("dimensions");
		dimensions.setAttribute("width", "" + get().getWidth());
		dimensions.setAttribute("height", "" + get().getHeight());
		dimensions.setAttribute("depth", "" + get().getDepth());
		root.appendChild(dimensions);

		Element center = doc.createElement("center");
		center.setAttribute("x", "" + get().getCenter().getX());
		center.setAttribute("y", "" + get().getCenter().getY());
		center.setAttribute("z", "" + get().getCenter().getZ());
		root.appendChild(center);

		Element playerSpawn = doc.createElement("playerSpawn");
		playerSpawn.setAttribute("x", "" + get().getPlayerSpawnRelativeToCenter().getX());
		playerSpawn.setAttribute("y", "" + get().getPlayerSpawnRelativeToCenter().getY());
		playerSpawn.setAttribute("z", "" + get().getPlayerSpawnRelativeToCenter().getZ());
		root.appendChild(playerSpawn);

		Element blocks = doc.createElement("blocks");
		for (ISerializableBlock b : get().getBlocks()) {
			Element block = doc.createElement("block");
			block.setAttribute("x", "" + b.getX());
			block.setAttribute("y", "" + b.getY());
			block.setAttribute("z", "" + b.getZ());
			block.setAttribute("blockdata", "" + b.getBlockData().getAsString());
			blocks.appendChild(block);
		}
		root.appendChild(blocks);

		saveDocument(doc);
	}
}
