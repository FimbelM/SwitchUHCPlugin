package fr.martinfimbel.switchuhc.persistence.loaders.configurations.switching;

import fr.martinfimbel.switchuhc.persistence.IDefaultContent;

public class SwitchDefaultContent implements IDefaultContent {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DefaultSwitchConfiguration";
	}

	@Override
	public String getDefaultXmlContent() {
		// TODO Auto-generated method stub
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Switch_UHC>\r\n" + 
				"  <version>1.0</version>\r\n" + 
				"  <name>DefaultSwitchConfiguration</name>\r\n" + 
				"  <border>\r\n" + 
				"    <center x=\"0\" z=\"0\"/>\r\n" + 
				"    <diameter final=\"20.0\" initial=\"3000.0\"/>\r\n" + 
				"    <speed>1.0</speed>\r\n" + 
				"  </border>\r\n" + 
				"  <time fraction=\"00:45\" game=\"02:00\" pvp=\"00:20\" scoreboardrefresh=\"5\" startswitch=\"00:30\" switch=\"00:20\" warning=\"01:55\"/>\r\n" + 
				"  <teams>\r\n" + 
				"    <team color=\"dark_red\" name=\"NEINNEINNEIN!!!\"/>\r\n" + 
				"    <team color=\"dark_gray\" name=\"JAJAJAJAJA!!!!!\"/>\r\n" + 
				"    <team color=\"gold\" name=\"TontonAdolf\"/>\r\n" + 
				"  </teams>\r\n" + 
				"</Switch_UHC>\r\n";
	}
}
