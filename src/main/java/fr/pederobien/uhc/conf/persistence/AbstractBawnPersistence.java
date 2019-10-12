package fr.pederobien.uhc.conf.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import fr.pederobien.uhc.world.blocks.IBawn;

public abstract class AbstractBawnPersistence<T extends IBawn> extends AbstractPersistence<T> {

	public AbstractBawnPersistence(T elt) {
		super(elt);
	}

	@Override
	protected void checkAndWriteDefault(T elt) {
		File file = new File(getPath());
		if (!file.exists()) {
			file.mkdirs();
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(file));
				writer.write(elt.getDefault());
			} catch (IOException e) {

			} finally {
				try {
					writer.close();
				} catch (IOException e) {

				}
			}
		}
		try {
			load(elt.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
