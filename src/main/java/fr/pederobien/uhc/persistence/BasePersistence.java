package fr.pederobien.uhc.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.persistence.loader.base.BaseLoaderV10;

public class BasePersistence extends AbstractBawnPersistence<IBase> {
	private static final double CURRENT_VERSION = 1.0;

	public BasePersistence() {
		super(IBase.DEFAULT);
		
		registerLoader(new BaseLoaderV10());
	}
	
	@Override
	protected String getPath() {
		return ROOT + "Bases/";
	}
	
	@Override
	protected String onLoadNotFound(String name) {
		return "Cannot find base named " + name;
	}

	@Override
	public void save() {
		Document doc = newDocument();
		doc.setXmlStandalone(true);

		Element root = doc.createElement("base");
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

		Element chests = doc.createElement("chests");
		for (ISerializableBlock b : get().getChests().keySet()) {
			Element chest = doc.createElement("chest");
			chest.setAttribute("x", "" + b.getX());
			chest.setAttribute("y", "" + b.getY());
			chest.setAttribute("z", "" + b.getZ());
			chest.setAttribute("color", "" + get().getChests().get(b).getChar());
			chest.setAttribute("blockdata", b.getBlockData().getAsString());
			chests.appendChild(chest);
		}
		root.appendChild(chests);

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
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><base>\r\n" + "  <version>1.0</version>\r\n"
				+ "  <name>DefaultBase</name>\r\n" + "  <dimensions depth=\"7\" height=\"5\" width=\"7\"/>\r\n"
				+ "  <center x=\"0\" y=\"80\" z=\"0\"/>\r\n" + "  <chests>\r\n"
				+ "    <chest blockdata=\"minecraft:chest[facing=north,type=single,waterlogged=false]\" color=\"4\" x=\"0\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <chest blockdata=\"minecraft:chest[facing=east,type=single,waterlogged=false]\" color=\"2\" x=\"1\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <chest blockdata=\"minecraft:chest[facing=west,type=single,waterlogged=false]\" color=\"5\" x=\"-1\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <chest blockdata=\"minecraft:chest[facing=south,type=single,waterlogged=false]\" color=\"e\" x=\"0\" y=\"1\" z=\"1\"/>\r\n"
				+ "  </chests>\r\n" + "  <blocks>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:quartz_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]\" x=\"-3\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"0\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"0\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"0\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:purple_wool\" x=\"-1\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"0\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:quartz_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]\" x=\"0\" y=\"0\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:red_wool\" x=\"0\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:yellow_wool\" x=\"0\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:quartz_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]\" x=\"0\" y=\"0\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"0\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:lime_wool\" x=\"1\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"0\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"0\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"0\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:quartz_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]\" x=\"3\" y=\"0\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"1\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"1\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:chest[facing=west,type=single,waterlogged=false]\" x=\"-1\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:chest[facing=north,type=single,waterlogged=false]\" x=\"0\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:chest[facing=south,type=single,waterlogged=false]\" x=\"0\" y=\"1\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:chest[facing=east,type=single,waterlogged=false]\" x=\"1\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"1\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"1\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"2\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"2\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"2\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"2\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:purple_wall_banner[facing=west]\" x=\"-3\" y=\"3\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:purple_wall_banner[facing=west]\" x=\"-3\" y=\"3\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:red_wall_banner[facing=north]\" x=\"-2\" y=\"3\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"3\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"3\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:yellow_wall_banner[facing=south]\" x=\"-2\" y=\"3\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:red_wall_banner[facing=north]\" x=\"2\" y=\"3\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"3\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"3\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:yellow_wall_banner[facing=south]\" x=\"2\" y=\"3\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:lime_wall_banner[facing=east]\" x=\"3\" y=\"3\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:lime_wall_banner[facing=east]\" x=\"3\" y=\"3\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"4\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"4\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"4\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"4\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"4\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"0\" y=\"4\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"4\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"1\" y=\"4\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"4\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"2\" y=\"4\" z=\"3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-3\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"0\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"1\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"2\"/>\r\n"
				+ "    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"3\"/>\r\n" + "  </blocks>\r\n"
				+ "</base>";
	}
}
