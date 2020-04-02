package fr.martinfimbel.switchuhc.persistence.loaders.configurations.switching;

import java.time.LocalTime;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;
import fr.martinfimbel.switchuhc.managers.EColor;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.persistence.loaders.IPersistenceLoader;

public class SwitchLoaderV10 extends AbstractSwitchGameLoader {

	public SwitchLoaderV10() {
		super("1.0");
	}

	@Override
	public IPersistenceLoader<ISwitchGameConfiguration> load(Node root) {
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
					case "speed":
						get().setBorderSpeed(Double.parseDouble(child.getChildNodes().item(0).getNodeValue()));
					default:
						break;
					}
				}
				break;
			case "time":
				get().setGameTime(LocalTime.parse(elt.getAttribute("game")));
				get().setFractionTime(LocalTime.parse(elt.getAttribute("fraction")));
				get().setPeriodSwitchTime(LocalTime.parse(elt.getAttribute("switch")));
				get().setStartSwitchTime(LocalTime.parse(elt.getAttribute("startswitch")));
				get().setWarningTime(LocalTime.parse(elt.getAttribute("warning")));
				get().setPvpTime(LocalTime.parse(elt.getAttribute("pvp")));
				get().setScoreboardRefresh(Long.parseLong(elt.getAttribute("scoreboardrefresh")));
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
			case "number":
				get().setNumberOfPlayerSwitchable(Integer.parseInt(elt.getAttribute("Number")));
				break;
			case "switchafter":
				get().setSwitchAfterBorderMoves(elt.getAttribute("SwitchABM"));
				break;
				
			default:
				break;
			}
		}
		return this;
	}

}
