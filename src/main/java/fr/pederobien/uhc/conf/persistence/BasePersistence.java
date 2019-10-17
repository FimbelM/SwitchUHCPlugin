package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.world.blocks.Base;
import fr.pederobien.uhc.world.blocks.IBase;
import fr.pederobien.uhc.world.blocks.ISerializableBlock;
import fr.pederobien.uhc.world.blocks.SerialisableBlock;

public class BasePersistence extends AbstractBawnPersistence<IBase> {
	private static final double CURRENT_VERSION = 1.0;

	public BasePersistence() {
		super(IBase.DEFAULT);
	}

	@Override
	public void load(String name) throws FileNotFoundException {
		try {
			Document doc = getDocument(getPath() + name + ".xml");
			Element root = doc.getDocumentElement();

			Node version = root.getElementsByTagName("version").item(0);

			switch (version.getChildNodes().item(0).getNodeValue()) {
			case "1.0":
				load10(root);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			throw new FileNotFoundException("Cannot find spawn named " + name);
		}
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
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><base>\r\n" + 
				"  <version>1.0</version>\r\n" + 
				"  <name>DefaultBase</name>\r\n" + 
				"  <dimensions depth=\"7\" height=\"5\" width=\"7\"/>\r\n" + 
				"  <center x=\"0\" y=\"80\" z=\"0\"/>\r\n" + 
				"  <chests>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=north,type=single,waterlogged=false]\" color=\"4\" x=\"0\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=east,type=single,waterlogged=false]\" color=\"2\" x=\"1\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=west,type=single,waterlogged=false]\" color=\"5\" x=\"-1\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <chest blockdata=\"minecraft:chest[facing=south,type=single,waterlogged=false]\" color=\"e\" x=\"0\" y=\"1\" z=\"1\"/>\r\n" + 
				"  </chests>\r\n" + 
				"  <blocks>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=east,half=bottom,shape=straight,waterlogged=false]\" x=\"-3\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-2\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:purple_wool\" x=\"-1\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"-1\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=south,half=bottom,shape=straight,waterlogged=false]\" x=\"0\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:red_wool\" x=\"0\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:yellow_wool\" x=\"0\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"0\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=north,half=bottom,shape=straight,waterlogged=false]\" x=\"0\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:lime_wool\" x=\"1\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"1\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:stone_bricks\" x=\"2\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:quartz_stairs[facing=west,half=bottom,shape=straight,waterlogged=false]\" x=\"3\" y=\"0\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"0\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=west,type=single,waterlogged=false]\" x=\"-1\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=north,type=single,waterlogged=false]\" x=\"0\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=south,type=single,waterlogged=false]\" x=\"0\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:chest[facing=east,type=single,waterlogged=false]\" x=\"1\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"1\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"2\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:purple_wall_banner[facing=west]\" x=\"-3\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:purple_wall_banner[facing=west]\" x=\"-3\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:red_wall_banner[facing=north]\" x=\"-2\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"-2\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:yellow_wall_banner[facing=south]\" x=\"-2\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:red_wall_banner[facing=north]\" x=\"2\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:bricks\" x=\"2\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:yellow_wall_banner[facing=south]\" x=\"2\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:lime_wall_banner[facing=east]\" x=\"3\" y=\"3\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:lime_wall_banner[facing=east]\" x=\"3\" y=\"3\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"3\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-3\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-2\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-2\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"-1\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"-1\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"0\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"0\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"1\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"1\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:mossy_cobblestone\" x=\"2\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"2\" y=\"4\" z=\"3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-3\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"-1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"0\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"1\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"2\"/>\r\n" + 
				"    <block blockdata=\"minecraft:air\" x=\"3\" y=\"4\" z=\"3\"/>\r\n" + 
				"  </blocks>\r\n" + 
				"</base>";
	}

	@Override
	protected String getPath() {
		return ROOT + "Bases/";
	}

	private void load10(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				set(new Base(elt.getChildNodes().item(0).getNodeValue()));
				break;
			case "dimensions":
				get().setDimensions(elt.getAttribute("width"), elt.getAttribute("height"), elt.getAttribute("depth"));
				break;
			case "center":
				get().setCenter(elt.getAttribute("x"), elt.getAttribute("y"), elt.getAttribute("z"));
				break;
			case "chests":
				HashMap<ISerializableBlock, ChatColor> chests = new HashMap<ISerializableBlock, ChatColor>();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element chest = (Element) elt.getChildNodes().item(j);
					chests.put(new SerialisableBlock(chest.getAttribute("x"), chest.getAttribute("y"), chest.getAttribute("z"), chest.getAttribute("blockdata")),
							ChatColor.getByChar(chest.getAttribute("color")));
				}
				get().setChests(chests);
				break;
			case "blocks":
				List<ISerializableBlock> blocks = new ArrayList<ISerializableBlock>();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element block = (Element) elt.getChildNodes().item(j);
					blocks.add(new SerialisableBlock(block.getAttribute("x"), block.getAttribute("y"),
							block.getAttribute("z"), block.getAttribute("blockdata")));
				}
				get().setBlocks(blocks);
				break;
			default:
				break;
			}
		}
	}
	
	protected void show() {
		System.out.println("Name : " + get().getName());
		System.out.println("Center : " + get().getCenter().getX() + " " + get().getCenter().getY() + " "
				+ get().getCenter().getZ());
		System.out.println("chests");
		for (ISerializableBlock b : get().getChests().keySet())
			System.out.println("\t" + b.getX() + " " + b.getY() + " " + b.getZ() + " " + get().getChests().get(b));
		System.out.println("Blocks");
		for (ISerializableBlock b : get().getBlocks())
			System.out.println(
					"\t" + b.getX() + " " + b.getY() + " " + b.getZ() + " " + b.getBlockData());
	}
}
