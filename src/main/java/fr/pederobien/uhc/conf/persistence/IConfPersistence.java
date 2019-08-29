package fr.pederobien.uhc.conf.persistence;

public interface IConfPersistence<T> extends IPersistence<T> {

	void save(T configuration);

	T getConfiguration();
}
