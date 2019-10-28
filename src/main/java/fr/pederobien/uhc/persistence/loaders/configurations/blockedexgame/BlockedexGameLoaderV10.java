package fr.pederobien.uhc.persistence.loaders.configurations.blockedexgame;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.persistence.loaders.IPersistenceLoader;

public class BlockedexGameLoaderV10 extends AbstractBlockedexgameLoader {

	public BlockedexGameLoaderV10() {
		super("1.0");
	}

	@Override
	public IPersistenceLoader<IBlockedexConfiguration> load(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				get().setName(elt.getChildNodes().item(0).getNodeValue());
				break;
			case "player":
				get().setRadiusAreaOnPlayerDie(Integer.parseInt(elt.getAttribute("areaOnPlayerDie")));
				get().setRadiusAreaOnPlayerKill(Integer.parseInt(elt.getAttribute("areaOnPlayerKill")));
				get().setDiameterAreaOnPlayerRespawn(Integer.parseInt(elt.getAttribute("diameterOnPlayerRespawn")));
				get().setStepOnMaxHealth(Double.parseDouble(elt.getAttribute("stepOnMaxHealth")));
				break;
			case "bases":
				get().setNorthBase(elt.getAttribute("north"));
				get().setSouthBase(elt.getAttribute("south"));
				get().setWestBase(elt.getAttribute("west"));
				get().setEastBase(elt.getAttribute("east"));
				get().setBaseFromSpawnDistance(Integer.parseInt(elt.getAttribute("distance")));
				break;
			default:
				break;
			}
		}
		return this;
	}
}
