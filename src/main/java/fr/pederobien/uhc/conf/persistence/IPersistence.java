package fr.pederobien.uhc.conf.persistence;

public interface IPersistence<T> {
	
	String attribut(String tag, String content);
	
	String openingTag(String tag);
	
	String openingTabTag(int tab, String tag);
	
	String closingTag(String tag);
	
	String closingTabTag(int tab, String tag);
	
	String tabAttribut(int tab, String tag, String content);
	 
	T load(String name);
	
	void save();
}
