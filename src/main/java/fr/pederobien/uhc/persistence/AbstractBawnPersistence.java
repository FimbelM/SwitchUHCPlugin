package fr.pederobien.uhc.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.pederobien.uhc.interfaces.IBawn;

public abstract class AbstractBawnPersistence<T extends IBawn> extends AbstractPersistence<T> {

	public AbstractBawnPersistence(T elt) {
		super(elt);
		checkAndWriteDefault();
	}

	protected abstract String getDefault();

	protected void checkAndWriteDefault() {
		File file = new File(getPath());
		if (!file.exists()) {
			BufferedWriter writer = null;
			try {
				file.mkdir();
				file = new File(getAbsolutePath());
				if (!file.exists())
					file.createNewFile();
				writer = new BufferedWriter(new FileWriter(new File(getAbsolutePath())));
				writer.write(getDefault());
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
