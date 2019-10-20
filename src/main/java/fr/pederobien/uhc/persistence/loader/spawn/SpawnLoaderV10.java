package fr.pederobien.uhc.persistence.loader.spawn;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.interfaces.ISpawn;
import fr.pederobien.uhc.persistence.loader.IPersistenceLoader;
import fr.pederobien.uhc.world.blocks.SerialisableBlock;

public class SpawnLoaderV10 extends AbstractSpawnLoader {

	public SpawnLoaderV10() {
		super("1.0");
	}

	@Override
	public IPersistenceLoader<ISpawn> load(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				get().setName(elt.getChildNodes().item(0).getNodeValue());
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
							block.getAttribute("z"),
							Material.valueOf(block.getAttribute("material")).createBlockData().getAsString()));
				}
				get().setBlocks(blocksStr);
				break;
			default:
				break;
			}
		}
		
		return this;
	}
}
