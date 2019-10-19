package fr.pederobien.uhc.commands.configuration.edit.editions;

import java.util.List;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public class CommonHelp extends AbstractEdition<IUnmodifiableName> {
	private IMapEdition conf;

	public CommonHelp(IMapEdition conf) {
		super(null, "help", "to display all features");
		this.conf = conf;
	}

	@Override
	public String edit(String[] args) {
		try {
			for (IMapEdition edition : conf.getEditions().values())
				if (edition.getLabel().equals(args[0]))
					return edition.help();
		} catch (IndexOutOfBoundsException e) {

		}
		return conf.help();
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return filter(conf.getEditions().keySet(), subArguments[0]);
		default:
			return emptyList();
		}
	}
}
