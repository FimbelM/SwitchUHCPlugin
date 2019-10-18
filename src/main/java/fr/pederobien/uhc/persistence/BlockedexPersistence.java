package fr.pederobien.uhc.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.pederobien.uhc.configurations.BlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.BaseManager;

public class BlockedexPersistence extends AbstractConfPersistence<IBlockedexConfiguration> {
	private static final double CURRENT_VERSION = 1.0;

	public BlockedexPersistence() {
		super(BlockedexConfiguration.DEFAULT);
	}

	@Override
	protected String getPath() {
		return GAME + "/BlockedexGame/";
	}

	@Override
	public IPersistence<IBlockedexConfiguration> load(String name) throws FileNotFoundException {
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
			throw new FileNotFoundException("Cannot find blockedex game style named " + name);
		}
		return this;
	}

	@Override
	public void save() {
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
		for (String t : get().getTeams().keySet()) {
			Element team = doc.createElement("team");
			team.setAttribute("name", t);
			team.setAttribute("color", "" + get().getTeams().get(t).getChar());
			teams.appendChild(team);
		}
		root.appendChild(teams);

		saveDocument(doc);
	}

	private void load10(Element root) {
		System.out.println("load10");
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			if (root.getChildNodes().item(i).getNodeType() != Node.ELEMENT_NODE)
				continue;
			Element elt = (Element) root.getChildNodes().item(i);

			switch (elt.getNodeName()) {
			case "name":
				set(new BlockedexConfiguration(elt.getChildNodes().item(0).getNodeValue()));
				break;
			case "player":
				get().setRadiusAreaOnPlayerDie(Integer.parseInt(elt.getAttribute("areaOnPlayerDie")));
				get().setRadiusAreaOnPlayerKill(Integer.parseInt(elt.getAttribute("areaOnPlayerKill")));
				get().setDiameterAreaOnPlayerRespawn(Integer.parseInt(elt.getAttribute("diameterOnPlayerRespawn")));
				get().setStepOnMaxHealth(Double.parseDouble(elt.getAttribute("stepOnMaxHealth")));
				break;
			case "bases":
				get().setNorthBase(BaseManager.getBaseByName(elt.getAttribute("north")));
				get().setSouthBase(BaseManager.getBaseByName(elt.getAttribute("south")));
				get().setWestBase(BaseManager.getBaseByName(elt.getAttribute("west")));
				get().setEastBase(BaseManager.getBaseByName(elt.getAttribute("east")));
				get().setBaseFromSpawnDistance(Integer.parseInt(elt.getAttribute("distance")));
				break;
			case "teams":
				HashMap<String, ChatColor> teams = new HashMap<String, ChatColor>();
				for (int j = 0; j < elt.getChildNodes().getLength(); j++) {
					if (elt.getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element team = (Element) elt.getChildNodes().item(j);
					teams.put(team.getAttribute("name"), ChatColor.getByChar(team.getAttribute("color")));
				}
				get().setTeams(teams);
				break;
			default:
				break;
			}
		}
	}

	protected void show() {
		System.out.println("Name : " + get().getName());
		System.out.println("Area on player die : " + get().getRadiusAreaOnPlayerDie());
		System.out.println("Area on player kill : " + get().getRadiusAreaOnPlayerKill());
		System.out.println("Step on max health : " + get().getStepOnMaxHealth());
		System.out.println("Diameter on player kill : " + get().getDiameterAreaOnPlayerRespawn());
		System.out.println("Bases");
		System.out.println("\tNorth base : " + get().getNorthBase().getName());
		System.out.println("\tSouth base : " + get().getSouthBase().getName());
		System.out.println("\tWest base : " + get().getWestBase().getName());
		System.out.println("\tEast base : " + get().getEastBase().getName());
		System.out.println("\tDistance from spawn : " + get().getBaseFromSpawnDistance());
		System.out.println("Team");
		for (String team : get().getTeams().keySet())
			System.out.println("\tName : " + team + ", color : " + get().getTeams().get(team));
	}
}
