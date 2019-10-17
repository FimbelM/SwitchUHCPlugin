package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		Element center = doc.createElement("center");
		center.setAttribute("x", "" + get().getCenter().getX());
		center.setAttribute("y", "" + get().getCenter().getY());
		center.setAttribute("z", "" + get().getCenter().getZ());
		root.appendChild(center);
		
		Element team = doc.createElement("team");
		team.appendChild(doc.createTextNode("" + get().getChests().size()));
		root.appendChild(team);

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
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
				"  <base>\r\n" + 
				"  <version>1.0</version>\r\n" + 
				"  <name>DefaultBase</name>\r\n" + 
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
			case "center":
				get().setCenter(elt.getAttribute("x"), elt.getAttribute("y"), elt.getAttribute("z"));
				break;
			case "blocks":
				List<ISerializableBlock> blocksStr = new ArrayList<ISerializableBlock>();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element block = (Element) elt.getChildNodes().item(j);
					blocksStr.add(new SerialisableBlock(block.getAttribute("x"), block.getAttribute("y"),
							block.getAttribute("z"), block.getAttribute("blockdata")));
				}
				get().setBlocks(blocksStr);
				break;
			default:
				break;
			}
		}
	}
}
