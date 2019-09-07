package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;

public class HungerGamePersistence extends AbstractConfPersistence<HungerGameConfiguration> {
	private static final String HUNGER_GAME = GAME + "HungerGame/";

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

			for (int i = 0; i < root.getChildNodes().getLength(); i++)
				if (root.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element elt = (Element) root.getChildNodes().item(i);
					if (elt.getNodeName().equals("name"))
						configuration = new HungerGameConfiguration(elt.getChildNodes().item(0).getNodeValue());

					else if (elt.getNodeName().equals("border"))
						for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
							if (elt.getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE)
								if (elt.getNodeName().equals("center"))
									configuration.setBorderCenter(elt.getAttribute("x"), elt.getAttribute("z"));
								else if (elt.getNodeName().equals("diameter")) {
									configuration
											.setInitialBorderDiameter(Double.parseDouble(elt.getAttribute("initial")));
									configuration.setFinalBorderDiameter(Double.parseDouble(elt.getAttribute("final")));
								}
						}
					else if (elt.getNodeName().equals("time")) {
						configuration.setGameTime(LocalTime.parse(elt.getAttribute("game")));
						configuration.setFractionTime(LocalTime.parse(elt.getAttribute("fraction")));
						configuration.setScoreboardRefresh(Long.parseLong(elt.getAttribute("scoreboardrefresh")));
					}
				}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save() {
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = doc.createElement("configuration");
		doc.appendChild(root);

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
}
