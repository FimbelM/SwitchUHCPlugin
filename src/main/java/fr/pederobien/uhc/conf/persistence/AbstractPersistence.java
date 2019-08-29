package fr.pederobien.uhc.conf.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractPersistence<T> implements IPersistence<T> {
	protected static final String ROOT = "Plugins/UHCPlugin/Ressources/";

	private BufferedWriter writer;
	
	@Override
	public String attribut(String tag, String content) {
		return tabAttribut(0, tag, content);
	}
	
	@Override
	public String openingTag(String tag) {
		return openingTabTag(0, tag);
	}
	
	@Override
	public String openingTabTag(int tab, String tag) {
		return tabTag(tab) + "<" + tag + ">";
	}
	
	@Override
	public String closingTag(String tag) {
		return closingTabTag(0, tag);
	}
	
	@Override
	public String closingTabTag(int tab, String tag) {
		return tabTag(tab) + "</" + tag + ">\r\n";
	}
	
	@Override
	public String tabAttribut(int tab, String tag, String content) {
		return openingTabTag(tab, tag) + content + closingTag(tag);
	}
	
	protected void write(String path, String content) {
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
	
	private String tabTag(int tab) {
		String tabulation = "";
		for (int i = 0; i < tab; i++)
			tabulation += "\t";
		return tabulation;
	}
}
