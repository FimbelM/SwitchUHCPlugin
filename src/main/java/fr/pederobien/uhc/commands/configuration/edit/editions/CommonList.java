package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import fr.pederobien.uhc.conf.IUnmodifiableName;
import fr.pederobien.uhc.persistence.IPersistence;

public abstract class CommonList<T extends IUnmodifiableName> extends AbstractEdition<T> {

	public CommonList(IPersistence<T> persistence, String explanation) {
		super(persistence, "list", explanation);
	}

	protected abstract String onSizeGreatThan0();

	protected abstract String onSizeEquals0();

	@Override
	public String edit(String[] args) {
		StringBuilder builder = new StringBuilder();
		List<String> list = getPersistence().list();
		if (list.size() > 0)
			builder.append(onSizeGreatThan0());
		else
			builder.append(onSizeEquals0());

		for (String str : list)
			builder.append(str.concat("\n"));
		return builder.toString();
	}
	
	@Override
	public List<String> getArguments(String[] subArguments) {
		return null;
	}
}
