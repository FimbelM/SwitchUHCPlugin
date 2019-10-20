package fr.pederobien.uhc.persistence.loader.hungergame;

import java.time.LocalTime;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.persistence.loader.IPersistenceLoader;

public class HungerGameLoaderV11 extends AbstractHungerGameLoader {

	public HungerGameLoaderV11() {
		super("1.1");
	}

	@Override
	public IPersistenceLoader<IHungerGameConfiguration> load(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				get().setName(elt.getChildNodes().item(0).getNodeValue());
				break;
			case "border":
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element child = (Element) elt.getChildNodes().item(j);
					switch (child.getNodeName()) {
					case "center":
						get().setBorderCenter(child.getAttribute("x"), child.getAttribute("z"));
						break;
					case "diameter":
						get().setInitialBorderDiameter(Double.parseDouble(child.getAttribute("initial")));
						get().setFinalBorderDiameter(Double.parseDouble(child.getAttribute("final")));
						break;
					default:
						break;
					}
				}
				break;
			case "time":
				get().setGameTime(LocalTime.parse(elt.getAttribute("game")));
				get().setFractionTime(LocalTime.parse(elt.getAttribute("fraction")));
				get().setScoreboardRefresh(Long.parseLong(elt.getAttribute("scoreboardrefresh")));
				break;
			case "teams":
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element t = (Element) elt.getChildNodes().item(j);
					ETeam team = ETeam.getByColorName(t.getAttribute("color"));
					team.setName(t.getAttribute("name"));
					get().addTeam(team);
				}
				break;
			default:
				break;
			}
		}
		get().createAssociatedTeams();
		return this;
	}
}