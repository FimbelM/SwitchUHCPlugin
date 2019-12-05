package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonList<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonList(MessageCode explanation) {
		super("list", explanation);
	}

	protected abstract MessageCode onSizeEquals0();

	protected abstract MessageCode onSizeEquals1(String name);

	protected abstract MessageCode onSizeGreaterThan0(String allNames);

	@Override
	public MessageCode edit(String[] args) {
		List<String> list = getPersistence().list();

		if (!list.contains(get().getName()))
			list.add(get().getName());

		switch (list.size()) {
		case 0:
			return onSizeEquals0();
		case 1:
			return onSizeEquals1(getAllNames(list));
		default:
			return onSizeGreaterThan0(getAllNames(list));
		}
	}

	private String getAllNames(List<String> list) {
		String allNames = "";
		for (String str : list)
			allNames += str + "\n";
		return allNames;
	}
}
