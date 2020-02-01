package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonList<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonList(IMessageCode explanation) {
		super("list", explanation);
	}

	protected abstract void onSizeEquals0();

	protected abstract void onSizeEquals1(String name);

	protected abstract void onSizeGreaterThan0(String allNames);

	@Override
	public void edit(String[] args) {
		List<String> list = getPersistence().list();

		if (!list.contains(get().getName()))
			list.add(get().getName());

		switch (list.size()) {
		case 0:
			onSizeEquals0();
			break;
		case 1:
			onSizeEquals1(getAllNames(list));
			break;
		default:
			onSizeGreaterThan0(getAllNames(list));
			break;
		}
	}

	private String getAllNames(List<String> list) {
		String allNames = "";
		for (String str : list)
			allNames += str + "\n";
		return allNames;
	}
}
