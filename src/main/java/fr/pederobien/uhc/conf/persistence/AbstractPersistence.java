package fr.pederobien.uhc.conf.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import fr.pederobien.uhc.conf.IUnmodifiableName;

public abstract class AbstractPersistence<T extends IUnmodifiableName> implements IPersistence<T> {
	protected static final String ROOT = "Plugins/UHCPlugin/Ressources/";
	private static final String END = ".xml";
	private DocumentBuilder builder;
	private T elt;
	protected boolean saved, loaded;

	public AbstractPersistence(T elt) {
		this.elt = elt;
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			f.setIgnoringElementContentWhitespace(true);
			builder = f.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		checkAndWriteDefault();
	}

	protected abstract String getPath();

	@Override
	public boolean exist(String name) {
		return new File(getAbsolutePath(name)).exists();
	}

	@Override
	public boolean delete(String name) {
		return new File(getAbsolutePath(name)).delete();
	}

	@Override
	public boolean isLoaded() {
		return loaded;
	}

	@Override
	public boolean isSaved() {
		return saved;
	}

	@Override
	public List<String> list() {
		String[] list = new File(getPath()).list();
		List<String> listOfString = new ArrayList<String>();
		for (int i = 0; i < list.length; i++)
			listOfString.add(list[i].substring(0, list[i].indexOf(END)));
		return listOfString;
	}

	@Override
	public T get() {
		return elt;
	}

	@Override
	public void set(T elt) {
		this.elt = elt;
	}

	protected void setSaved(boolean saved) {
		this.saved = saved;
	}

	protected void checkAndWriteDefault() {
		File file = new File(getPath());
		if (!file.exists()) {
			file.mkdirs();
			save();
		} else
			try {
				load(get().getName());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}

	protected String getAbsolutePath() {
		return getAbsolutePath(get().getName());
	}

	protected String getAbsolutePath(String name) {
		return getPath() + name + END;
	}

	protected Document newDocument() {
		return builder.newDocument();
	}

	protected Document getDocument(String path) throws IOException {
		try {
			return builder.parse(new File(path));
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void saveDocument(Document doc) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(getAbsolutePath()));

			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
