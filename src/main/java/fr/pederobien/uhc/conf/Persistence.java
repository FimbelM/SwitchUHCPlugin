package fr.pederobien.uhc.conf;

import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

public class Persistence {
	private static final String ROOT = "Plugins/UHCPlugin/Ressources/";
	private static final String SPAWNS = ROOT + "Spawns/";
	private static final String GAME = ROOT + "Games/";
	
	public Persistence() {
		File file = new File(SPAWNS);
		if (!file.exists())
			file.mkdirs();
		file = new File(GAME);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	public boolean persisteSpawn(Spawn spawn) throws SAXException, IOException {
		return true;
	}
	
	public Spawn loadSpawn(String name) {
		return new Spawn();
	}
	
	public boolean persisteConfiguration(Configuration game) {
		return true;
	}
	
	public Configuration loadConfiguration(String name) {
		return new Configuration();
	}
}
