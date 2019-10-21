package fr.pederobien.uhc.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.persistence.loaders.configurations.blockedexgame.BlockedexGameDefaultContent;
import fr.pederobien.uhc.persistence.loaders.configurations.blockedexgame.BlockedexGameLoaderV10;

public class BlockedexPersistence extends AbstractConfPersistence<IBlockedexConfiguration> {
	private static final double CURRENT_VERSION = 1.0;

	public BlockedexPersistence() {
		super(new BlockedexGameDefaultContent());

		registerLoader(new BlockedexGameLoaderV10());
	}

	@Override
	protected String getPath() {
		return GAME + "/BlockedexGame/";
	}

	@Override
	protected String onLoadNotFound(String name) {
		return "Cannot find blockedex game style named " + name;
	}

	@Override
	public void save() {
		if (get() == null)
			return;
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = doc.createElement("blockedex");
		doc.appendChild(root);

		Element version = doc.createElement("version");
		version.appendChild(doc.createTextNode("" + CURRENT_VERSION));
		root.appendChild(version);

		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

		Element player = doc.createElement("player");
		player.setAttribute("areaOnPlayerDie", get().getRadiusAreaOnPlayerDie().toString());
		player.setAttribute("areaOnPlayerKill", get().getRadiusAreaOnPlayerKill().toString());
		player.setAttribute("diameterOnPlayerRespawn", get().getDiameterAreaOnPlayerRespawn().toString());
		player.setAttribute("stepOnMaxHealth", get().getStepOnMaxHealth().toString());
		root.appendChild(player);

		Element bases = doc.createElement("bases");
		bases.setAttribute("north", get().getNorthBase().getName());
		bases.setAttribute("south", get().getSouthBase().getName());
		bases.setAttribute("west", get().getWestBase().getName());
		bases.setAttribute("east", get().getEastBase().getName());
		bases.setAttribute("distance", get().getBaseFromSpawnDistance().toString());
		root.appendChild(bases);
		
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
}
