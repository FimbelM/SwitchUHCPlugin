package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

public class NorthBaseBlockedexGame extends AbstractBaseEdition {

	protected NorthBaseBlockedexGame() {
		super("north", "to set the base at the north of the spawn");
	}

	@Override
	protected void setBase(String baseName) {
		get().setNorthBase(baseName);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getNorthBase() + " defined as the north base";
	}
}
