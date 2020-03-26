package fr.martinfimbel.switchuhc.persistence.loaders.configurations.blockedexgame;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.managers.EColor;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.persistence.loaders.IPersistenceLoader;

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
			case "teams":
				get().getTeams().clear();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element t = (Element) elt.getChildNodes().item(j);
					get().addTeam(TeamsManager.createTeam(t.getAttribute("name"), EColor.getByColorName(t.getAttribute("color"))));
				}
				break;
			default:
				break;
			}
		}
		return this;
	}
}
