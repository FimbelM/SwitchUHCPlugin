package fr.pederobien.uhc.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.persistence.loaders.configurations.hungergame.HungerGameDefaultContent;
import fr.pederobien.uhc.persistence.loaders.configurations.hungergame.HungerGameLoaderV10;
import fr.pederobien.uhc.persistence.loaders.configurations.hungergame.HungerGameLoaderV11;
import fr.pederobien.uhc.persistence.loaders.configurations.hungergame.HungerGameLoaderV12;

public class HungerGamePersistence extends AbstractConfPersistence<IHungerGameConfiguration> {
	private static final double CURRENT_VERSION = 1.2;

	public HungerGamePersistence() {
		super(new HungerGameDefaultContent());

		registerLoader(new HungerGameLoaderV10()).registerLoader(new HungerGameLoaderV11()).registerLoader(new HungerGameLoaderV12());
	}

	@Override
	protected String getPath() {
		return GAME + "HungerGame/";
	}

	@Override
	protected String onLoadNotFound(String name) {
		return "Cannot find hunger game style named " + name;
	}

	@Override
	public void save() {
		if (get() == null)
			return;
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

		Element speed = doc.createElement("speed");
		speed.appendChild(doc.createTextNode(get().getBorderSpeed().toString()));
		border.appendChild(speed);

		Element time = doc.createElement("time");
		time.setAttribute("game", get().getGameTime().toString());
		time.setAttribute("fraction", get().getFractionTime().toString());
		time.setAttribute("warning", get().getWarningTime().toString());
		time.setAttribute("pvp", get().getPvpTime().toString());
		time.setAttribute("scoreboardrefresh", "" + get().getScoreboardRefresh());
		root.appendChild(time);

		Element teams = doc.createElement("teams");
		for (ITeam t : get().getTeams()) {
			Element team = doc.createElement("team");
			team.setAttribute("name", t.getName());
			team.setAttribute("color", t.getColor().getColorName());
			teams.appendChild(team);
		}
		root.appendChild(teams);

		saveDocument(doc);
	}
}
