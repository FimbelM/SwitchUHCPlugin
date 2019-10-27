package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class CommonList<T extends IUnmodifiableName> extends AbstractMapEdition<T> {

	public CommonList(String explanation) {
		super("list", explanation);
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
		
		list.stream().forEach(str -> builder.append(str.concat("\n")));

		return builder.toString();
	}
}
