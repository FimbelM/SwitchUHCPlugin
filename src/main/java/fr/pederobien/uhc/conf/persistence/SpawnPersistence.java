package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
		try {
			Document doc = getDocument(SPAWNS + name + ".xml");
			Element root = doc.getDocumentElement();

			for (int i = 0; i < root.getChildNodes().getLength(); i++)
				if (root.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element elt = (Element) root.getChildNodes().item(i);
					if (elt.getNodeName().equals("name"))
						spawn = new Spawn(elt.getChildNodes().item(0).getNodeValue());

					else if (elt.getNodeName().equals("center"))
						spawn.setCenter(elt.getAttribute("x"), elt.getAttribute("y"), elt.getAttribute("z"));

					else if (elt.getNodeName().equals("blocks")) {
						List<String> blocksStr = new ArrayList<String>();
						for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
							if (elt.getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
								Element block = (Element) elt.getChildNodes().item(j);
								blocksStr.add(block.getAttribute("x") + ";" + block.getAttribute("y") + ";"
										+ block.getAttribute("z") + ";" + block.getAttribute("material"));
							}
							spawn.setBlocks(blocksStr);
						}
					}
				}
		} catch (NullPointerException e) {
			throw new FileNotFoundException("Cannot find spawn named " + name);
		}
	}

	@Override
	public void save() {
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = doc.createElement("spawn");
		doc.appendChild(root);

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
			block.setAttribute("material", "" + spawn.getBlocks().get(coord));
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
}
