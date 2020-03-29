package fr.martinfimbel.switchuhc.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.persistence.loaders.configurations.switching.SwitchDefaultContent;
import fr.martinfimbel.switchuhc.persistence.loaders.configurations.switching.SwitchLoaderV10;

public class SwitchPersistence  extends AbstractConfPersistence<ISwitchGameConfiguration>{
	private static final double CURRENT_VERSION = 1.0;
	
	public SwitchPersistence() {
		super(new SwitchDefaultContent());
	
	registerLoader(new SwitchLoaderV10());
	}

	@Override
	public void save() {
		if (get() == null)
			return;
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = doc.createElement("Switch_UHC");
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
		time.setAttribute("startswitch", get().getStartSwitchTime().toString());
		time.setAttribute("switch", get().getPeriodSwitchTime().toString());
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

	@Override
	protected String getPath() {
		return GAME + "Switch_UHC/";
	}

	@Override
	protected String onLoadNotFound(String name) {
		return "Cannot find Switch UHC game style named " + name;
	}

}
