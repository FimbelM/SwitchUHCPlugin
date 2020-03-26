package fr.martinfimbel.switchuhc.persistence.loaders.bawn.spawn;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.martinfimbel.switchuhc.interfaces.ISerializableBlock;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;
import fr.martinfimbel.switchuhc.persistence.loaders.IPersistenceLoader;
import fr.martinfimbel.switchuhc.world.blocks.Dimension;
import fr.martinfimbel.switchuhc.world.blocks.SerialisableBlock;

public class SpawnLoaderV12 extends AbstractSpawnLoader {

	public SpawnLoaderV12() {
		super("1.2");
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
			case "dimensions":
				get().setDimension(new Dimension(elt.getAttribute("width"), elt.getAttribute("height"), elt.getAttribute("depth")));
				break;
			case "center":
				get().setCenter(elt.getAttribute("x"), elt.getAttribute("y"), elt.getAttribute("z"));
				break;
			case "playerSpawn":
				get().setPlayerSpawnRelativeToCenter(elt.getAttribute("x"), elt.getAttribute("y"), elt.getAttribute("z"));
				break;
			case "blocks":
				List<ISerializableBlock> blocksStr = new ArrayList<ISerializableBlock>();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element block = (Element) elt.getChildNodes().item(j);
					blocksStr.add(new SerialisableBlock(block.getAttribute("x"), block.getAttribute("y"), block.getAttribute("z"),
							block.getAttribute("blockdata")));
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
