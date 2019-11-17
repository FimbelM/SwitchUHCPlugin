package fr.pederobien.uhc.persistence.loaders.configurations.blockedexgame;

import fr.pederobien.uhc.persistence.IDefaultContent;

public class BlockedexGameDefaultContent implements IDefaultContent {

	@Override
	public String getName() {
		return "DefaultBlockedexStyle";
	}

	@Override
	public String getDefaultXmlContent() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><blockedex>\r\n" + 
				"  <version>1.0</version>\r\n" + 
				"  <name>" + getName() + "</name>\r\n" + 
				"  <player areaOnPlayerDie=\"5\" areaOnPlayerKill=\"5\" diameterOnPlayerRespawn=\"1000\" stepOnMaxHealth=\"1.0\"/>\r\n" + 
				"  <bases distance=\"1000\" east=\"DefaultBase\" north=\"DefaultBase\" south=\"DefaultBase\" west=\"DefaultBase\"/>\r\n" + 
				"  <teams>\r\n" + 
				"    <team color=\"yellow\" name=\"vikings\"/>\r\n" + 
				"    <team color=\"dark_red\" name=\"barbaric\"/>\r\n" + 
				"    <team color=\"gold\" name=\"spartiate\"/>\r\n" + 
				"    <team color=\"aqua\" name=\"knight\"/>\r\n" + 
				"  </teams>\r\n" + 
				"</blockedex>\r\n";
	}
}
