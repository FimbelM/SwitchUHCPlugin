package fr.pederobien.uhc.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.interfaces.ISpawn;
import fr.pederobien.uhc.persistence.loader.spawn.SpawnLoaderV10;
import fr.pederobien.uhc.persistence.loader.spawn.SpawnLoaderV11;
import fr.pederobien.uhc.persistence.loader.spawn.SpawnLoaderV12;

public class SpawnPersistence extends AbstractBawnPersistence<ISpawn> {

	public SpawnPersistence() {
		super(ISpawn.DEFAULT);

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

	@Override
	protected String getDefault() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "  <spawn>\r\n" + "  <version>1.2</version>\r\n"
				+ "  <name>DefaultSpawn</name>\r\n" + "  <dimensions width=\"5\" height=\"1\" depth=\"5\"/>\r\n"
				+ "  <center x=\"0\" y=\"90\" z=\"0\"/>\r\n" + "  <blocks>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-2\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"-1\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"0\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"1\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bedrock\" x=\"2\" y=\"0\" z=\"2\"/>\r\n" + "  </blocks>\r\n"
				+ "</spawn>";
	}
}
