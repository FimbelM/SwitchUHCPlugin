package fr.pederobien.uhc.conf.persistence;

public interface IPersistence<T> {
		
	String openingTag(String tag);
	
	String openingTabTag(int tab, String tag);
	
	String closingTag(String tag);
	
	String closingTabTag(int tab, String tag);
	
	String tabAttribut(int tab, String tag, Object content);
	 
	T load(String name);
	
	void save();
	
	void save(T toSave);
}
