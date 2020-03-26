package fr.martinfimbel.switchuhc.dictionary.dictionaries;

import fr.martinfimbel.switchuhc.dictionary.IDictionary;

public class DictionaryFactory {
	private static IDictionary englishDictionary;
	private static IDictionary frenchDictionary;

	public static synchronized IDictionary createEnglishDictionary() {
		if (englishDictionary == null)
			englishDictionary = new EnglishDictionary();
		return englishDictionary;
	}

	public static synchronized IDictionary createFrenchDictionary() {
		if (frenchDictionary == null)
			frenchDictionary = new FrenchDictionary();
		return frenchDictionary;
	}

}
