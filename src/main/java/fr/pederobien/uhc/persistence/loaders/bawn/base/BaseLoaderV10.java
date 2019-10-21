package fr.pederobien.uhc.persistence.loaders.bawn.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.persistence.loaders.IPersistenceLoader;
import fr.pederobien.uhc.world.blocks.SerialisableBlock;

public class BaseLoaderV10 extends AbstractBaseLoader {

	public BaseLoaderV10() {
		super("1.0");
	}

	@Override
	public IPersistenceLoader<IBase> load(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				get().setName(elt.getChildNodes().item(0).getNodeValue());
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
					chests.put(
							new SerialisableBlock(chest.getAttribute("x"), chest.getAttribute("y"),
									chest.getAttribute("z"), chest.getAttribute("blockdata")),
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
		return this;
	}
}
