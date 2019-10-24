package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.interfaces.IBase;

public class ListBase extends CommonList<IBase> {

	public ListBase() {
		super("to display all existing base(s)");
	}

	@Override
	protected String onSizeGreatThan0() {
		return "List of existing base(s) :\n";
	}

	@Override
	protected String onSizeEquals0() {
		return "No existing base";
	}
}
