package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;

public class HungerGamePersistence extends AbstractConfPersistence<HungerGameConfiguration> {
	private static final String HUNGER_GAME = GAME + "HungerGame/";
	private static final double CURRENT_VERSION = 1.0;

	public HungerGamePersistence() {
		super(HungerGameConfiguration.DEFAULT);
		checkAndWriteDefault(HUNGER_GAME, get());
	}

	@Override
	public boolean exist(String name) {
		return super.exist(HUNGER_GAME + name + ".xml");
	}

	@Override
	public void load(String name) throws FileNotFoundException {
		try {
			Document doc = getDocument(HUNGER_GAME + name + ".xml");
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
		Element root = doc.createElement("configuration");
		doc.appendChild(root);

		Element version = doc.createElement("version");
		version.appendChild(doc.createTextNode("" + CURRENT_VERSION));
		root.appendChild(version);

		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(configuration.getName()));
		root.appendChild(name);

		Element border = doc.createElement("border");
		root.appendChild(border);

		Element center = doc.createElement("center");
		center.setAttribute("x", "" + configuration.getBorderCenter().getX());
		center.setAttribute("z", "" + configuration.getBorderCenter().getZ());
		border.appendChild(center);

		Element diameter = doc.createElement("diameter");
		diameter.setAttribute("initial", "" + configuration.getInitialBorderDiameter());
		diameter.setAttribute("final", "" + configuration.getFinalBorderDiameter());
		border.appendChild(diameter);

		Element time = doc.createElement("time");
		time.setAttribute("game", configuration.getGameTime().toString());
		time.setAttribute("fraction", configuration.getFractionTime().toString());
		time.setAttribute("scoreboardrefresh", "" + configuration.getScoreboardRefresh());
		root.appendChild(time);

		saveDocument(HUNGER_GAME + configuration.getName() + ".xml", doc);
	}

	@Override
	public HungerGameConfiguration get() {
		return configuration;
	}

	@Override
	public void set(HungerGameConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public List<String> list() {
		return getList(HUNGER_GAME);
	}

	private void load10(Node root) {
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				configuration = new HungerGameConfiguration(elt.getChildNodes().item(0).getNodeValue());
				break;
			case "border":
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element child = (Element) elt.getChildNodes().item(j);
					switch (child.getNodeName()) {
					case "center":
						configuration.setBorderCenter(child.getAttribute("x"), child.getAttribute("z"));
						break;
					case "diameter":
						configuration.setInitialBorderDiameter(Double.parseDouble(child.getAttribute("initial")));
						configuration.setFinalBorderDiameter(Double.parseDouble(child.getAttribute("final")));
						break;
					default:
						break;
					}
				}
				break;
			case "time":
				configuration.setGameTime(LocalTime.parse(elt.getAttribute("game")));
				configuration.setFractionTime(LocalTime.parse(elt.getAttribute("fraction")));
				configuration.setScoreboardRefresh(Long.parseLong(elt.getAttribute("scoreboardrefresh")));
				break;
			default:
				break;
			}
		}
	}
	
	protected void show() {
		System.out.println("Name : " + configuration.getName());
		System.out.println("Border");
		System.out.println("\tCenter : " + configuration.getBorderCenter().getX() + " " + configuration.getBorderCenter().getZ());
		System.out.println("\tDiameter");
		System.out.println("\t\tInitial : " + configuration.getInitialBorderDiameter());
		System.out.println("\t\tFinal : " + configuration.getFinalBorderDiameter());
		System.out.println("Time");
		System.out.println("\tGame : " + configuration.getGameTime());
		System.out.println("\tFraction : " + configuration.getFractionTime());
		System.out.println("\tScoreboard refresh : " + configuration.getScoreboardRefresh());
	}
}
