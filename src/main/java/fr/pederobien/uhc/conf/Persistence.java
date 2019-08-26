package fr.pederobien.uhc.conf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Persistence {
	private static final String ROOT = "Plugins/UHCPlugin/Ressources/";
	private static final String SPAWNS = ROOT + "Spawns/";
	private static final String GAME = ROOT + "Games/";
	private BufferedWriter writer;
	
	public Persistence() {
		File file = new File(SPAWNS);
		if (!file.exists()) {
			file.mkdirs();
			persisteSpawn(Spawn.DEFAULT);
		}
		file = new File(GAME);
		if (!file.exists()) {
			file.mkdirs();
			persisteConfiguration(Configuration.DEFAULT);
		}
	}
	
	public void persisteSpawn(Spawn spawn) {
		write(SPAWNS + spawn.getName() + ".txt", spawn.toString());
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

	public String getSpawnsName() {
		String spawnsName = "";
		
		return spawnsName;
	}
	
	private void write(String path, String content) {
        FileWriter fw = null;

        try {

            fw = new FileWriter(path);
            writer = new BufferedWriter(fw);
            writer.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (writer != null)
                    writer.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
	}
}
