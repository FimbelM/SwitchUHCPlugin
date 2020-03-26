package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations;

import java.io.FileNotFoundException;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;

public abstract class CommonAsCurrent<T extends IConfiguration> extends AbstractConfEdition<T> {
	private IConfigurationContext context;

	public CommonAsCurrent(IConfigurationContext context, IMessageCode explanation) {
		super("ascurrent", explanation);
		this.context = context;
	}

	protected abstract void onStyleNotDefined(String name);

	@Override
	public void edit(String[] args) {
		if (args.length == 0) {
			context.setCurrentConfiguration(getPersistence().get());
			sendMessage(MessageCode.AS_CURRENT_STYLE_DEFINED, get().getName());
		} else {
			getPersistence().save();
			String name = "";
			try {
				name = args[0];
				getPersistence().load(name);
				context.setCurrentConfiguration(get());
				sendMessage(MessageCode.AS_CURRENT_STYLE_DEFINED, get().getName());
			} catch (FileNotFoundException e) {
				onStyleNotDefined(name);
			}
		}
	}
}
