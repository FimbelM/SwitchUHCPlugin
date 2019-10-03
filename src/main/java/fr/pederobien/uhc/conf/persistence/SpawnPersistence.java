package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.Spawn.Coordinate;

public class SpawnPersistence extends AbstractPersistence<Spawn> {
	protected static final String SPAWNS = ROOT + "Spawns/";
	private static final double CURRENT_VERSION = 1.1;
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
		try {
			Document doc = getDocument(SPAWNS + name + ".xml");
			Element root = doc.getDocumentElement();

			Node version = root.getElementsByTagName("version").item(0);

			switch (version.getChildNodes().item(0).getNodeValue()) {
			case "1.0":
				load10(root);
				break;
			case "1.1":
				load11(root);
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
		Element root = doc.createElement("spawn");
		doc.appendChild(root);

		Element version = doc.createElement("version");
		version.appendChild(doc.createTextNode("" + CURRENT_VERSION));
		root.appendChild(version);

		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(spawn.getName()));
		root.appendChild(name);

		Element center = doc.createElement("center");
		center.setAttribute("x", "" + spawn.getCenter().getX());
		center.setAttribute("y", "" + spawn.getCenter().getY());
		center.setAttribute("z", "" + spawn.getCenter().getZ());
		root.appendChild(center);

		Element blocks = doc.createElement("blocks");
		for (Coordinate coord : spawn.getBlocks().keySet()) {
			Element block = doc.createElement("block");
			block.setAttribute("x", "" + coord.getX());
			block.setAttribute("y", "" + coord.getY());
			block.setAttribute("z", "" + coord.getZ());
			block.setAttribute("blockdata", "" + spawn.getBlocks().get(coord));
			blocks.appendChild(block);
		}
		root.appendChild(blocks);

		saveDocument(SPAWNS + spawn.getName() + ".xml", doc);
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

	private void load10(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);
			
			switch (elt.getNodeName()) {
			case "name":
				spawn = new Spawn(elt.getChildNodes().item(0).getNodeValue());
				break;
			case "center":
				spawn.setCenter(elt.getAttribute("x"), elt.getAttribute("y"), elt.getAttribute("z"));
				break;
			case "blocks":
				List<String> blocksStr = new ArrayList<String>();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element block = (Element) elt.getChildNodes().item(j);
					blocksStr.add(block.getAttribute("x") + ";" + block.getAttribute("y") + ";"
							+ block.getAttribute("z") + ";"
							+ Material.valueOf(block.getAttribute("material")).createBlockData().getAsString());
				}
				spawn.setBlocks(blocksStr);
				break;
			default:
				break;
			}
		}
		System.out.println("spawn loaded");
	}

	private void load11(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				spawn = new Spawn(elt.getChildNodes().item(0).getNodeValue());
				break;
			case "center":
				spawn.setCenter(elt.getAttribute("x"), elt.getAttribute("y"), elt.getAttribute("z"));
				break;
			case "blocks":
				List<String> blocksStr = new ArrayList<String>();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element block = (Element) elt.getChildNodes().item(j);
					blocksStr.add(block.getAttribute("x") + ";" + block.getAttribute("y") + ";"
							+ block.getAttribute("z") + ";" + block.getAttribute("blockdata"));
				}
				spawn.setBlocks(blocksStr);
				break;
			default:
				break;
			}
		}
	}

	protected void show() {
		System.out.println("Name : " + spawn.getName());
		System.out.println("Center : " + spawn.getCenter().getX() + " " + spawn.getCenter().getY() + " "
				+ spawn.getCenter().getZ());
		System.out.println("Blocks");
		for (Coordinate coord : spawn.getBlocks().keySet())
			System.out.println(
					"\t" + coord.getX() + " " + coord.getY() + " " + coord.getZ() + " " + spawn.getBlocks().get(coord));
	}
}
