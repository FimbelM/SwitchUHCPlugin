package fr.pederobien.uhc.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;
import fr.pederobien.uhc.observer.IObsPersistence;
import fr.pederobien.uhc.persistence.loaders.IPersistenceLoader;

public abstract class AbstractPersistence<T extends IUnmodifiableName> implements IPersistence<T> {
	protected static final String ROOT = "plugins/UHCPlugin/Ressources/";
	private static final String END = ".xml";
	private DocumentBuilder builder;
	private T elt;
	private HashMap<String, IPersistenceLoader<T>> map;
	private IDefaultContent defaultContent;
	private List<IObsPersistence<T>> observers;
	protected boolean saved, loaded;

	public AbstractPersistence(IDefaultContent defaultContent) {
		this.defaultContent = defaultContent;
		map = new HashMap<String, IPersistenceLoader<T>>();
		observers = new ArrayList<IObsPersistence<T>>();
		loaded = false;
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

	protected abstract String onLoadNotFound(String name);

	@Override
	public IPersistence<T> load(String name) throws FileNotFoundException {
		try {
			Document doc = getDocument(getPath() + name + ".xml");
			Element root = doc.getDocumentElement();

			Node version = root.getElementsByTagName("version").item(0);

			set(getLoaders().get(version.getChildNodes().item(0).getNodeValue()).load(root).get());
		} catch (IOException e) {
			throw new FileNotFoundException(onLoadNotFound(name));
		}
		return this;
	}

	@Override
	public IPersistence<T> registerLoader(IPersistenceLoader<T> loader) {
		map.put(loader.getVersion(), loader);
		return this;
	}
	
	@Override
	public IDefaultContent getDefaultContent() {
		return defaultContent;
	}

	@Override
	public Map<String, IPersistenceLoader<T>> getLoaders() {
		return Collections.unmodifiableMap(map);
	}

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
	final public void set(T elt) {
		this.elt = elt;
		onCurrentChange();
	}
	
	@Override
	public IPersistence<T> addObserver(IObsPersistence<T> obs) {
		observers.add(obs);
		return this;
	}
	
	@Override
	public IPersistence<T> removeObserver(IObsPersistence<T> obs) {
		observers.remove(obs);
		return this;
	}

	protected void setSaved(boolean saved) {
		this.saved = saved;
	}

	protected void checkParentFolderExistence() {
		File file = new File(getPath());
		if (!file.exists())
			file.mkdirs();
	}

	protected boolean checkSaveExistence() {
		File file = new File(getAbsolutePath());
		if (!file.exists())
			try {
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return false;
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

	private void checkAndWriteDefault() {
		File file = new File(getPath());
		if (!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(getAbsolutePath(defaultContent.getName()));
		if (!file.exists()) {
			BufferedWriter writer = null;
			try {
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
	
	private void onCurrentChange() {
		for (IObsPersistence<T> obs : observers)
			obs.onCurrentChange(get());
	}
}
