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

			Node confName = root.getElementsByTagName("name").item(0).getChildNodes().item(0);
			configuration = new HungerGameConfiguration(confName.getNodeValue());

			Element borderCenter = (Element) root.getElementsByTagName("border").item(0).getChildNodes().item(0);
			configuration.setBorderCenter(borderCenter.getAttribute("x"), borderCenter.getAttribute("z"));

			Element borderDiameter = (Element) root.getElementsByTagName("border").item(0).getChildNodes().item(1);
			configuration.setInitialBorderDiameter(Double.parseDouble(borderDiameter.getAttribute("initial")));
			configuration.setFinalBorderDiameter(Double.parseDouble(borderDiameter.getAttribute("final")));

			Element time = (Element) root.getElementsByTagName("time").item(0);
			configuration.setGameTime(LocalTime.parse(time.getAttribute("game")));
			configuration.setFractionTime(LocalTime.parse(time.getAttribute("fraction")));
			configuration.setScoreboardRefresh(Long.parseLong(time.getAttribute("scoreboardrefresh")));
		} catch (NullPointerException e) {
			throw new FileNotFoundException("Cannot find spawn named " + name);
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
