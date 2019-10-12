package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;

public class HungerGamePersistence extends AbstractConfPersistence<IHungerGameConfiguration> {
	private static final double CURRENT_VERSION = 1.0;

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
			throw new FileNotFoundException("Cannot find hunger game style named " + name);
		}
	}

	@Override
	public void save() {
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = doc.createElement("get()");
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

		saveDocument(getPath() + get().getName() + ".xml", doc);
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
