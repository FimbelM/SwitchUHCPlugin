package fr.pederobien.uhc.conf.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPersistence<T> implements IPersistence<T> {
	protected static final String ROOT = "Plugins/UHCPlugin/Ressources/";
	private BufferedWriter writer;
	protected boolean saved, loaded;

	@Override
	public boolean exist(String name) {
		return new File(name).exists();
	}

	@Override
	public boolean delete(String name) {
		return new File(name).delete();
	}

	@Override
	public boolean isLoaded() {
		return loaded;
	}

	@Override
	public boolean isSaved() {
		return saved;
	}

	protected void setSaved(boolean saved) {
		this.saved = saved;
	}

	protected String openingTag(String tag) {
		return openingTabTag(0, tag);
	}

	protected String openingTabTag(int tab, String tag) {
		return tabTag(tab) + "<" + tag + ">\r\n";
	}

	protected String closingTag(String tag) {
		return closingTabTag(0, tag);
	}

	protected String closingTabTag(int tab, String tag) {
		return tabTag(tab) + "</" + tag + ">\r\n";
	}

	protected String attribut(int tab, String tag, Object content) {
		return tabTag(tab) + "<" + tag + ">" + content.toString() + closingTag(tag);
	}

	protected void checkAndWriteDefault(String path, T configuration) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
			save();
		}
	}

	protected void write(String path, String content) {
		FileWriter fw = null;

		try {

			fw = new FileWriter(path);
			writer = new BufferedWriter(fw);
			writer.write("<?xml version = \"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\r\n");
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
		saved = true;
	}

	protected List<String> getList(String path) {
		String[] list = new File(path).list();
		List<String> listOfString = new ArrayList<String>();
		for (int i = 0; i < list.length; i++)
			listOfString.add(list[i].substring(0, list[i].indexOf(".xml")));
		return listOfString;
	}

	private String tabTag(int tab) {
		String tabulation = "";
		for (int i = 0; i < tab; i++)
			tabulation += "\t";
		return tabulation;
	}
}
