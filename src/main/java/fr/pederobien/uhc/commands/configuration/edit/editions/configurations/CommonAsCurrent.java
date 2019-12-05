package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.io.FileNotFoundException;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public abstract class CommonAsCurrent<T extends IConfiguration> extends AbstractConfEdition<T> {
	private IConfigurationContext context;

	public CommonAsCurrent(IConfigurationContext context, MessageCode explanation) {
		super("ascurrent", explanation);
		this.context = context;
	}

	protected abstract MessageCode onStyleNotDefined(String name);

	@Override
	public MessageCode edit(String[] args) {
		if (args.length == 0) {
			context.setCurrentConfiguration(getPersistence().get());
			return MessageCode.AS_CURRENT_STYLE_DEFINED.withArgs(get().getName());
		} else {
			getPersistence().save();
			String name = "";
			try {
				name = args[0];
				getPersistence().load(name);
				context.setCurrentConfiguration(get());
				return MessageCode.AS_CURRENT_STYLE_DEFINED.withArgs(get().getName());
			} catch (FileNotFoundException e) {
				return onStyleNotDefined(name);
			}
		}
	}
}
