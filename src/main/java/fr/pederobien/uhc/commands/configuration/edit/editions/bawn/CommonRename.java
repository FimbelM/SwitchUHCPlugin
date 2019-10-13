package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBawn;

public abstract class CommonRename<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonRename(IPersistence<T> persistence, String explanation) {
		super(persistence, "rename", explanation);
	}

	protected abstract String onAlreadyExisting(String newName);

	protected abstract String onRename(String oldName, String newName);

	protected abstract String onNameIsMissing();

	@Override
	public String edit(String[] args) {
		try {
			String newName = args[0];
			if (getPersistence().exist(newName))
				return onAlreadyExisting(newName);
			else {
				String oldName = get().getName();
				get().setName(newName);
				return onRename(oldName, newName);
			}
		} catch (IndexOutOfBoundsException e) {
			return onNameIsMissing();
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<newname>");
		default:
			return null;
		}
	}
}
