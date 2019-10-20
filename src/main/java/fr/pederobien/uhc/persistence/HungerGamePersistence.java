package fr.pederobien.uhc.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.ETeam;

public class HungerGamePersistence extends AbstractConfPersistence<IHungerGameConfiguration> {
	private static final double CURRENT_VERSION = 1.1;

	public HungerGamePersistence() {
		super(HungerGameConfiguration.DEFAULT);
	}

	@Override
	protected String getPath() {
		return GAME + "HungerGame/";
	}

	@Override
	public boolean exist(String name) {
		return super.exist(getPath() + name + ".xml");
	}

	@Override
	public IPersistence<IHungerGameConfiguration> load(String name) throws FileNotFoundException {
		try {
			Document doc = getDocument(getPath() + name + ".xml");
			Element root = doc.getDocumentElement();

			Node version = root.getElementsByTagName("version").item(0);

			switch (version.getChildNodes().item(0).getNodeValue()) {
			case "1.0":
				load10(root);
				break;
			case "1.1":
				load11(root);
			default:
				break;
			}
		} catch (IOException e) {
			throw new FileNotFoundException("Cannot find hunger game style named " + name);
		}
		return this;
	}

	@Override
	public void save() {
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = doc.createElement("hungergame");
		doc.appendChild(root);

		Element version = doc.createElement("version");
		version.appendChild(doc.createTextNode("" + CURRENT_VERSION));
		root.appendChild(version);

		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

		Element border = doc.createElement("border");
		root.appendChild(border);

		Element center = doc.createElement("center");
		center.setAttribute("x", "" + get().getBorderCenter().getX());
		center.setAttribute("z", "" + get().getBorderCenter().getZ());
		border.appendChild(center);

		Element diameter = doc.createElement("diameter");
		diameter.setAttribute("initial", "" + get().getInitialBorderDiameter());
		diameter.setAttribute("final", "" + get().getFinalBorderDiameter());
		border.appendChild(diameter);

		Element time = doc.createElement("time");
		time.setAttribute("game", get().getGameTime().toString());
		time.setAttribute("fraction", get().getFractionTime().toString());
		time.setAttribute("scoreboardrefresh", "" + get().getScoreboardRefresh());
		root.appendChild(time);
		
		Element teams = doc.createElement("teams");
		for (ETeam t : get().getTeams()) {
			Element team = doc.createElement("team");
			team.setAttribute("name", t.getNameWithoutColor());
			team.setAttribute("color", t.getColorName());
			teams.appendChild(team);
		}
		root.appendChild(teams);

		saveDocument(doc);
	}

	private void load10(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				set(new HungerGameConfiguration(elt.getChildNodes().item(0).getNodeValue()));
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
			default:
				break;
			}
		}
	}
	
	private void load11(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				set(new HungerGameConfiguration(elt.getChildNodes().item(0).getNodeValue()));
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
	}

	protected void show() {
		System.out.println("Name : " + get().getName());
		System.out.println("Border");
		System.out.println("\tCenter : " + get().getBorderCenter().getX() + " " + get().getBorderCenter().getZ());
		System.out.println("\tDiameter");
		System.out.println("\t\tInitial : " + get().getInitialBorderDiameter());
		System.out.println("\t\tFinal : " + get().getFinalBorderDiameter());
		System.out.println("Time");
		System.out.println("\tGame : " + get().getGameTime());
		System.out.println("\tFraction : " + get().getFractionTime());
		System.out.println("\tScoreboard refresh : " + get().getScoreboardRefresh());
	}
}
