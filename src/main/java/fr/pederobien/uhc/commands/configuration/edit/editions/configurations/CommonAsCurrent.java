package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.io.FileNotFoundException;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public abstract class CommonAsCurrent<T extends IConfiguration> extends AbstractConfEdition<T> {
	private IConfigurationContext context;

	public CommonAsCurrent(IConfigurationContext context, String explanation) {
		super("ascurrent", explanation);
		this.context = context;
	}

	protected abstract String onNameIsMissing();

	protected abstract String onStyleNotDefined();

	@Override
	public String edit(String[] args) {
		if (args.length == 0) {
			context.setCurrentConfiguration(getPersistence().get());
			return "Style " + get().getName() + " defined as current style";
		} else {
			getPersistence().save();
			try {
				getPersistence().load(args[0]);
				context.setCurrentConfiguration(get());
				return "Style " + get().getName() + " defined as current style";
			} catch (IndexOutOfBoundsException e) {
				return onNameIsMissing();
			} catch (FileNotFoundException e) {
				return onStyleNotDefined();
			}
		}
	}
}
