package fr.pederobien.uhc.persistence.loaders.configurations.hungergame;

import fr.pederobien.uhc.persistence.IDefaultContent;

public class HungerGameDefaultContent implements IDefaultContent {

	@Override
	public String getName() {
		return "DefaultHungerGameStyle";
	}

	@Override
	public String getDefaultXmlContent() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><hungergame>\r\n" + 
				"  <version>1.2</version>\r\n" + 
				"  <name>DefaultHungerGameStyle</name>\r\n" + 
				"  <border>\r\n" + 
				"    <center x=\"0\" z=\"0\"/>\r\n" + 
				"    <diameter final=\"10.0\" initial=\"2000.0\"/>\r\n" + 
				"  </border>\r\n" + 
				"  <time fraction=\"00:45\" game=\"02:00\" pvp=\"00:00\" scoreboardrefresh=\"5\" warning=\"00:05\"/>\r\n" + 
				"  <teams>\r\n" + 
				"    <team color=\"dark_aqua\" name=\"knights\"/>\r\n" + 
				"    <team color=\"yellow\" name=\"vikings\"/>\r\n" + 
				"    <team color=\"dark_red\" name=\"barbaric\"/>\r\n" + 
				"    <team color=\"gold\" name=\"spartiates\"/>\r\n" + 
				"  </teams>\r\n" + 
				"</hungergame>";
	}

}
