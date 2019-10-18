package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.AbstractBawnEdition;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;

public class LaunchBaseTemp extends AbstractBawnEdition<IBase> {

	public LaunchBaseTemp(IPersistence<IBase> persistence) {
		super(persistence, "launch", "to launch a base");
	}

	@Override
	public String edit(String[] args) {
		get().setCenter(args[0], args[1], args[2]);
		get().launch();
		return "Base " + get().getName() + " launched";
	}
	
	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<X> <Y> <Z>");
		case 2:
			return Arrays.asList("<Y> <Z>");
		case 3:
			return Arrays.asList("<Z>");
		default:
			return emptyList();
		}
	}
}
