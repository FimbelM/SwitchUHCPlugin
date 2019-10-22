package fr.pederobien.uhc.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.persistence.loaders.bawn.base.BaseDefaultContent;
import fr.pederobien.uhc.persistence.loaders.bawn.base.BaseLoaderV10;

public class BasePersistence extends AbstractBawnPersistence<IBase> {
	private static final double CURRENT_VERSION = 1.0;

	public BasePersistence() {
		super(new BaseDefaultContent());

		registerLoader(new BaseLoaderV10());
	}

	@Override
	protected String getPath() {
		return ROOT + "Bases/";
	}

	@Override
	protected String onLoadNotFound(String name) {
		return "Cannot find base named " + name;
	}

	@Override
	public void save() {
		if (get() == null)
			return;
		Document doc = newDocument();
		doc.setXmlStandalone(true);

		Element root = doc.createElement("base");
		doc.appendChild(root);

		Element version = doc.createElement("version");
		version.appendChild(doc.createTextNode("" + CURRENT_VERSION));
		root.appendChild(version);

		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

		Element dimensions = doc.createElement("dimensions");
		dimensions.setAttribute("width", "" + get().getWidth());
		dimensions.setAttribute("height", "" + get().getHeight());
		dimensions.setAttribute("depth", "" + get().getDepth());
		root.appendChild(dimensions);

		Element center = doc.createElement("center");
		center.setAttribute("x", "" + get().getCenter().getX());
		center.setAttribute("y", "" + get().getCenter().getY());
		center.setAttribute("z", "" + get().getCenter().getZ());
		root.appendChild(center);

		Element chests = doc.createElement("chests");
		for (ISerializableBlock b : get().getChests().keySet()) {
			Element chest = doc.createElement("chest");
			chest.setAttribute("x", "" + b.getX());
			chest.setAttribute("y", "" + b.getY());
			chest.setAttribute("z", "" + b.getZ());
			chest.setAttribute("color", "" + get().getChests().get(b).getColorName());
			chest.setAttribute("team", "" + get().getChests().get(b).getNameWithoutColor());
			chest.setAttribute("blockdata", b.getBlockData().getAsString());
			chests.appendChild(chest);
		}
		root.appendChild(chests);

		Element blocks = doc.createElement("blocks");
		for (ISerializableBlock b : get().getBlocks()) {
			Element block = doc.createElement("block");
			block.setAttribute("x", "" + b.getX());
			block.setAttribute("y", "" + b.getY());
			block.setAttribute("z", "" + b.getZ());
			block.setAttribute("blockdata", "" + b.getBlockData().getAsString());
			blocks.appendChild(block);
		}
		root.appendChild(blocks);

		saveDocument(doc);
	}
}
