package fr.pederobien.uhc.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.persistence.loaders.bawn.IDefaultContent;

public abstract class AbstractBawnPersistence<T extends IBawn> extends AbstractPersistence<T> {
	private String defaultName;
	private IDefaultContent defaultContent;

	protected AbstractBawnPersistence(String defaultName, IDefaultContent defaultContent) {
		this.defaultName = defaultName;
		this.defaultContent = defaultContent;
		checkAndWriteDefault();
	}

	protected void checkAndWriteDefault() {
		File file = new File(getPath());
		if (!file.exists()) {
			BufferedWriter writer = null;
			try {
				file.mkdir();
				file = new File(getAbsolutePath(defaultName));
				if (!file.exists())
					file.createNewFile();
				writer = new BufferedWriter(new FileWriter(file));
				writer.write(defaultContent.getDefaultXmlContent());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
